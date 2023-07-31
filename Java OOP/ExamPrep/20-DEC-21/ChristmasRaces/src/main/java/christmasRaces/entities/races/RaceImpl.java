package christmasRaces.entities.races;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class RaceImpl implements Race{

    private String name;

    private int laps;

    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps){
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().length() < 5){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if(laps < 1){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_NUMBER_OF_LAPS, 1));
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
        return Collections.unmodifiableCollection(drivers);
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
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        if (containsDriver(driver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .DRIVER_ALREADY_ADDED, driver.getName(), this.name));
        }
    }

    private boolean containsDriver(Driver driver) {
        String name = driver.getName();
        for(Driver d : drivers){
            if(d.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
