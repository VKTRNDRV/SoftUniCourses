package exam.service.impl;

import exam.model.Town;
import exam.model.dtos.TownImportDTO;
import exam.model.dtos.TownImportRootDTO;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    private ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent(){
        try {
            return Files.readString(Path.of(TOWNS_FILE_PATH));
        }catch (IOException ignored){}
        return "";
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        TownImportRootDTO root = this.xmlParser
                .fromString(readTownsFileContent(), TownImportRootDTO.class);
        List<TownImportDTO> townDTOs = root.getTowns();
        StringBuilder output = new StringBuilder();
        for(TownImportDTO townImportDTO : townDTOs){
            if(this.validationUtils.isValid(townImportDTO) &&
                    isNameUnique(townImportDTO.getName())){
                Town town = this.modelMapper.map(townImportDTO, Town.class);
                output.append("Successfully imported Town ")
                        .append(town.getName())
                        .append(System.lineSeparator());
                this.townRepository.save(town);
            }else {
                output.append("Invalid town\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.townRepository
                .findFirstByName(name).isEmpty();
    }
}
