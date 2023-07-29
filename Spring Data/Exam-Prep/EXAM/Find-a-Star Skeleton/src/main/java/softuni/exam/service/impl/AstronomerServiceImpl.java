package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDTO;
import softuni.exam.models.dto.AstronomerImportRootDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class AstronomerServiceImpl implements AstronomerService {

    private AstronomerRepository astronomerRepository;

    private StarRepository starRepository;

    private static String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtil validationUtil;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        AstronomerImportRootDTO root = this.xmlParser.fromString(
                readAstronomersFromFile(), AstronomerImportRootDTO.class);
        List<AstronomerImportDTO> astronomerDTOs = root.getAstronomers();
        StringBuilder output = new StringBuilder();
        boolean isValid;
        for(AstronomerImportDTO astronomerImportDTO : astronomerDTOs){
            isValid = true;
            Astronomer astronomer = null;
            if(this.validationUtil.isValid(astronomerImportDTO) &&
                    isFullNameUnique(astronomerImportDTO.getFirstName(),
                            astronomerImportDTO.getLastName())){
                astronomer = this.modelMapper.map(
                        astronomerImportDTO, Astronomer.class);
            }else {
                isValid = false;
            }

            if(isValid){
                Optional<Star> star = this.starRepository.findById(
                        astronomerImportDTO.getObservingStarId());
                if(star.isPresent()){
                    astronomer.setObservingStar(star.get());
                }else {
                    isValid = false;
                }
            }

            if(isValid && astronomerImportDTO.isBirthdayNull()){
                astronomer.setBirthday(astronomerImportDTO
                        .getBirthdayAsLocalDate());
            }

            if(isValid){
                output.append(String.format(
                        "Successfully imported astronomer %s %s - %.2f\n",
                        astronomer.getFirstName(), astronomer.getLastName(),
                        astronomer.getAverageObservationHours()));
                this.astronomerRepository.save(astronomer);
            }else {
                output.append("Invalid astronomer\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isFullNameUnique(String firstName, String lastName) {
        return this.astronomerRepository
                .findFirstByFirstNameAndLastName(firstName, lastName)
                .isEmpty();
    }
}
