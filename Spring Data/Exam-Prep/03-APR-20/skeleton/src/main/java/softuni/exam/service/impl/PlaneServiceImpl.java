package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PlaneImportDTO;
import softuni.exam.models.dtos.PlaneImportDtoRoot;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {

    private PlaneRepository planeRepository;

    private XmlParser xmlParser;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    private static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws IOException, JAXBException {
        PlaneImportDtoRoot root = this.xmlParser
                .fromString(readPlanesFileContent(), PlaneImportDtoRoot.class);
        List<PlaneImportDTO> planeDTOs = root.getPlanes();
        StringBuilder output = new StringBuilder();
        for(PlaneImportDTO planeImportDTO : planeDTOs){
            if(this.validationUtil.isValid(planeImportDTO) &&
                    isRegisterNumberUnique(planeImportDTO.getRegisteredNumber())){
                Plane plane = this.modelMapper.map(planeImportDTO, Plane.class);
                output.append("Successfully imported Plane ")
                        .append(plane.getRegisteredNumber());
                this.planeRepository.save(plane);
            }else {
                output.append("Invalid Plane");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isRegisterNumberUnique(String registerNumber) {
        return this.planeRepository
                .findFirstByRegisteredNumber(registerNumber)
                .isEmpty();
    }
}
