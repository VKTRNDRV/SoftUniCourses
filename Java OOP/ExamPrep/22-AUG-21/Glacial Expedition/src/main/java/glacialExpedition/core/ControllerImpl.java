package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.*;

public class ControllerImpl implements Controller {

    private Repository<Explorer> explorerRepository;

    private Repository<State> stateRepository;

    private int exploredStatesCount;

    public ControllerImpl(){
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.exploredStatesCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        if(type.equals("AnimalExplorer")){
            explorer = new AnimalExplorer(explorerName);
        }else if (type.equals("GlacierExplorer")){
            explorer = new GlacierExplorer(explorerName);
        }else if (type.equals("NaturalExplorer")){
            explorer = new NaturalExplorer(explorerName);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(ConstantMessages
                .EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        Collection<String> stateExhibits = state.getExhibits();
        stateExhibits.addAll(Arrays.asList(exhibits));
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if(explorer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);
        return String.format(ConstantMessages
                .EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorers = new ArrayList<>();
        for(Explorer explorer : explorerRepository.getCollection()){
            if(explorer.getEnergy() > 50){
                explorers.add(explorer);
            }
        }
        if(explorers.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);
        this.exploredStatesCount++;
        int retiredCount = 0;
        for(Explorer explorer : explorers){
            if (!explorer.canSearch()){
                retiredCount++;
                //retireExplorer(explorer.getName());
            }
        }

        return String.format(ConstantMessages
                .STATE_EXPLORER, stateName, retiredCount);
    }

    @Override
    public String finalResult() {
        Collection<Explorer> explorers = this
                .explorerRepository.getCollection();
        StringBuilder output = new StringBuilder();
        output.append(String.format(ConstantMessages
                        .FINAL_STATE_EXPLORED, exploredStatesCount))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());
        for(Explorer explorer : explorers){
            output.append(String.format(ConstantMessages
                            .FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages
                            .FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator());

            Collection<String> exhibits = explorer
                    .getSuitcase().getExhibits();
            if(exhibits.size() == 0){
                output.append(String.format(ConstantMessages
                        .FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            }else {
                output.append(String.format(ConstantMessages
                        .FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(ConstantMessages
                        .FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, exhibits)));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
