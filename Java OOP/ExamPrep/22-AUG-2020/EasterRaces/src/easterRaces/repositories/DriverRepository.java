package easterRaces.repositories;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {

    private Collection<Driver> drivers;

    public DriverRepository(){
        this.drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        for(Driver driver : drivers){
            if (driver.getName().equals(name)){
                return driver;
            }
        }
        throw new IllegalArgumentException(String.format(
                ExceptionMessages.DRIVER_NOT_FOUND, name));
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections
                .unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver model) {
        if(model == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.DRIVER_INVALID);
        }
        if(containsDriverName(model.getName())){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_EXISTS,
                    model.getName()));
        }
        this.drivers.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        if(model == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.DRIVER_INVALID);
        }
        for(Driver driver : drivers){
            if(driver.getName().equals(model.getName())){
                drivers.remove(driver);
                return true;
            }
        }
        return false;
    }

    private boolean containsDriverName(String name){
        for(Driver driver : drivers){
            if (driver.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
