package christmasRaces.repositories;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> models;

    public RaceRepository(){
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        for(Race race : models){
            if(race.getName().equals(name)){
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Race model) {
        if(getByName(model.getName()) == null){
            models.add(model);
            return;
        }
        throw new IllegalArgumentException(String.format(
                ExceptionMessages.RACE_EXISTS, model.getName()));
    }

    @Override
    public boolean remove(Race model) {
        Race race = getByName(model.getName());
        if(race == null){
            return false;
        }
        this.models.remove(race);
        return true;
    }

//    private void validateNotNull(Race race){
//        if(race == null){
//            throw new IllegalArgumentException(
//                    ExceptionMessages.RACE_NOT_FOUND);
//        }
//    }
}
