package easterRaces.entities.racers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceImpl implements Race{

    private String name;

    private int laps;

    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps){
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    private static final int MIN_NAME_LENGTH = 5;

    private static final int MIN_LAP_COUNT = 1;


    public void setName(String name) {
        if(name == null ||
                name.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_NAME,
                    name,  MIN_NAME_LENGTH));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if(laps < MIN_LAP_COUNT){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_NUMBER_OF_LAPS,
                            MIN_LAP_COUNT));
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        validateDriver(driver);
        this.drivers.add(driver);
    }

    private void validateDriver(Driver driver) {
        if(driver == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.DRIVER_INVALID);
        }
        if(!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_NOT_PARTICIPATE,
                    driver.getName()));
        }
        if(containsDriverName(driver.getName())){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_ALREADY_ADDED,
                    driver.getName(), this.name));
        }
    }

    private boolean containsDriverName(String name){
        for(Driver driver : drivers){
            if(driver.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
