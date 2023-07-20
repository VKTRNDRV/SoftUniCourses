package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Constants;
import softuni.exam.models.dto.PartInsertDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// TODO: Implement all methods
@Service
public class PartsServiceImpl implements PartsService {

    private PartsRepository partsRepository;
    private Gson gson;
    private ModelMapper modelMapper;

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ModelMapper modelMapper) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        String json = readPartsFileContent();
        StringBuilder output = new StringBuilder();
        PartInsertDTO[] partInsertDTOs = this.gson.fromJson(json, PartInsertDTO[].class);
        for(PartInsertDTO partInsertDTO : partInsertDTOs){
            if(isValid(partInsertDTO)){
                Part part = this.modelMapper.map(partInsertDTO, Part.class);
                this.partsRepository.save(part);
                output.append(String.format(
                        Constants.SUCCESSFULLY_IMPORTED_FORMAT + Constants.PART_IMPORT_FORMAT,
                        "part", part.getPartName(), part.getPrice()));
            }else {
                output.append(String.format(Constants.INVALID_FORMAT, "part"));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isValid(PartInsertDTO partInsertDTO) {
        String partName = partInsertDTO.getPartName();
        Double price = partInsertDTO.getPrice();
        Integer qty = partInsertDTO.getQuantity();
        if(price < 10 || price > 2000 || qty <= 0){
            return false;
        }
        if(partName.length() < 2 || partName.length() > 19 || partName.isEmpty() ||
                this.partsRepository.findFirstByPartName(partName).isPresent()){
            return false;
        }
        return true;
    }
}
