package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {

    private AgentRepository agentRepository;

    private TownRepository townRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    private static String AGENTS_IMPORT_FILE_PATH = "src/main/resources/files/json/agents.json";

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, Gson gson, ModelMapper modelMapper) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_IMPORT_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder output = new StringBuilder();
        AgentImportDTO[] agentDTOs = this.gson.fromJson(readAgentsFromFile(), AgentImportDTO[].class);
        for(AgentImportDTO agentImportDTO : agentDTOs){
            if(isValid(agentImportDTO)){
                Agent agent = this.modelMapper.map(agentImportDTO, Agent.class);
                Optional<Town> town = this.townRepository
                        .findFirstByTownName(agentImportDTO.getTown());
                town.ifPresent(agent::setTown);
                this.agentRepository.save(agent);
                output.append(String.format("Successfully imported agent - %s %s",
                        agent.getFirstName(), agent.getLastName()));
            }else {
                output.append("Invalid agent");
            }
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }

    private boolean isValid(AgentImportDTO agentImportDTO){
        String firstName = agentImportDTO.getFirstName();
        String lastName = agentImportDTO.getLastName();
        String email = agentImportDTO.getEmail();
        /*String townName = agentImportDTO.getTown();*/
        if(firstName == null || lastName == null || email == null || /*townName == null ||*/
                firstName.length() < 2 || lastName.length() < 2 ||
                !email.contains("@") || !email.contains(".") ||
                this.agentRepository.findFirstByFirstName(firstName).isPresent() ||
                this.agentRepository.findFirstByEmail(email).isPresent() /*||
                this.townRepository.findFirstByTownName(townName).isEmpty()*/){
            return false;
        }
        return true;
    }
}
