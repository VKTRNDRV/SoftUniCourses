package easterRaces.repositories;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> races;

    public RaceRepository(){
        this.races = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        for(Race race : races){
            if (race.getName().equals(name)){
                return race;
            }
        }
        throw new IllegalArgumentException(String.format(
                ExceptionMessages.RACE_NOT_FOUND, name));
    }

    @Override
    public Collection<Race> getAll() {
        return Collections
                .unmodifiableCollection(races);
    }

    @Override
    public void add(Race model) {
        if(containsRaceWithName(model.getName())){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_EXISTS,
                    model.getName()));
        }
        this.races.add(model);
    }

    private boolean containsRaceWithName(String raceName){
        for(Race race : races){
            if (race.getName().equals(raceName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Race model) {
        for(Race race : races){
            if(race.getName().equals(model.getName())){
                races.remove(race);
                return true;
            }
        }
        return false;
    }
}
