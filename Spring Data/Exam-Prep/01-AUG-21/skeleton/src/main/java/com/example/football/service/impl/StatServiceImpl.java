package com.example.football.service.impl;

import com.example.football.models.dto.StatImportDTO;
import com.example.football.models.dto.StatImportRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtils;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

//ToDo - Implement all methods
@Service
public class StatServiceImpl implements StatService {

    private StatRepository statRepository;

    private static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;


    @Autowired
    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent()  {
        try {
            return Files.readString(Path.of(STATS_FILE_PATH));
        }catch (IOException ignored){}
        return "";
    }

    @Override
    public String importStats() {
        StatImportRootDTO root = this.xmlParser.fromString(
                readStatsFileContent(), StatImportRootDTO.class);
        List<StatImportDTO> statDTOs = root.getStats();
        StringBuilder output = new StringBuilder();
        for(StatImportDTO statImportDTO : statDTOs){
            if(this.validationUtils.isValid(statImportDTO) &&
                    isCompositeUnique(statImportDTO.getShooting(),
                            statImportDTO.getPassing(),
                            statImportDTO.getEndurance())){
                Stat stat = this.modelMapper
                        .map(statImportDTO, Stat.class);
                output.append(String.format(
                        "Successfully imported Stat %.2f - %.2f - %.2f\n",
                        stat.getShooting(), stat.getPassing(), stat.getEndurance()));
                this.statRepository.save(stat);
            }else {
                output.append("Invalid Stat\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isCompositeUnique(float shooting, float passing, float endurance){
        return this.statRepository
                .findFirstByShootingAndPassingAndEndurance(shooting, passing, endurance)
                .isEmpty();
    }
}
