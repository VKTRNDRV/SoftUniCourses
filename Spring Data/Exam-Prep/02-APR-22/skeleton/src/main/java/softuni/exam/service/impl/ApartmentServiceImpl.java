package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportDTO;
import softuni.exam.models.dto.ApartmentsImportWrapper;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.models.enums.ApartmentType;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private ApartmentRepository apartmentRepository;

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private static String APARTMENTS_IMPORT_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_IMPORT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        String xml = readApartmentsFromFile();
        ApartmentsImportWrapper wrapper = this.xmlParser
                .fromString(xml, ApartmentsImportWrapper.class);
        List<ApartmentImportDTO> apartmentDTOs = wrapper.getApartmentImportDTOs();
        for(ApartmentImportDTO apartmentImportDTO : apartmentDTOs){
            if(isValid(apartmentImportDTO)){
                Apartment apartment = this.modelMapper.map(apartmentImportDTO, Apartment.class);
                Optional<Town> town = this.townRepository.findFirstByTownName(apartmentImportDTO.getTownName());
                town.ifPresent(apartment::setTown);
                this.apartmentRepository.save(apartment);
                output.append(String.format("Successfully imported apartment %s - %.2f",
                        apartment.getApartmentType().toString(),
                        apartment.getArea()));
            }else {
                output.append("Invalid apartment");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isValid(ApartmentImportDTO apartmentImportDTO) {
        String aptType = apartmentImportDTO.getApartmentType();
        String townName = apartmentImportDTO.getTownName();
        Double area = apartmentImportDTO.getArea();
        if(!ApartmentType.contains(aptType) || area < 40.0){
            return false;
        }
        List<Apartment> apartmentsInTown = new ArrayList<>();
        try {
            apartmentsInTown = this.apartmentRepository
                    .findAllByTown(this.townRepository.findFirstByTownName(townName).get());
        }catch (Exception e){

        }
        for(Apartment apartment : apartmentsInTown){
            if (Double.compare(apartment.getArea(), area) == 0){
                return false;
            }
        }

        return true;
    }
}
