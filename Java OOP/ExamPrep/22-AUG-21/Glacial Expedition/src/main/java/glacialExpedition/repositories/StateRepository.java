package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateRepository implements Repository<State>{

    Collection<State> states;

    public StateRepository(){
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(states);
    }

    @Override
    public void add(State entity) {
        this.states.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        for(State state : states){
            if(entity.getName().equals(state.getName())){
                states.remove(state);
                return true;
            }
        }
        return false;
    }

    @Override
    public State byName(String name) {
        for(State state : states){
            if(state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
