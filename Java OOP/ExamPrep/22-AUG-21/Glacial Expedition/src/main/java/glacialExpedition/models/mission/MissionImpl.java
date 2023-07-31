package glacialExpedition.models.mission;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        Collection<String> exhibitsInState = state.getExhibits();

        List<String> exhibitsTaken = new ArrayList<>();
        for(Explorer explorer : explorers){
            Collection<String> explorerSuitcase = explorer
                    .getSuitcase().getExhibits();

            // iterate exhibits until explorer cannot search
            for(String exhibit : exhibitsInState){
                if(explorer.canSearch()){
                    explorer.search();
                    explorerSuitcase.add(exhibit);
                    exhibitsTaken.add(exhibit);
                }else {
                    break;
                }
            }

            // remove all taken exhibits from state
            for(String takenExhibit : exhibitsTaken){
                exhibitsInState.remove(takenExhibit);
            }
            exhibitsTaken.clear();
        }
    }
}
