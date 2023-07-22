package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    private static String TOWNS_IMPORT_FILE_PATH = "src/main/resources/files/json/towns.json";

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_IMPORT_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder output = new StringBuilder();
        TownImportDTO[] townDTOs = this.gson
                .fromJson(readTownsFileContent(), TownImportDTO[].class);
        for(TownImportDTO townImportDTO : townDTOs){
            if(isValid(townImportDTO)){
                Town town = this.modelMapper.map(townImportDTO,  Town.class);
                this.townRepository.save(town);
                output.append(String.format("Successfully imported town %s - %d",
                        town.getTownName(),
                        town.getPopulation()));
            }else{
                output.append("Invalid town");
            }
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }

    private boolean isValid(TownImportDTO townImportDTO){
        String townName = townImportDTO.getTownName();
        if(townName == null|| townName.length() < 2 ||
                townImportDTO.getPopulation() == null ||
                townImportDTO.getPopulation() <= 0 ||
                this.townRepository.findFirstByTownName(townName).isPresent()){
            return false;
        }
        return true;
    }
}
