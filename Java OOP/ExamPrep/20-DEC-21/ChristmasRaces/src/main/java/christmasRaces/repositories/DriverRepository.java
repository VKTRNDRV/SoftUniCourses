package christmasRaces.repositories;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {

    private Collection<Driver> models;

    public DriverRepository(){
        this.models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        for(Driver driver : models){
            if(driver.getName().equals(name)){
                return driver;
            }
        }
        return null;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver model) {
        validateNotNull(model);
        if(getByName(model.getName()) == null){
            models.add(model);
            return;
        }
        throw new IllegalArgumentException(String.format(
                ExceptionMessages.DRIVER_EXISTS, model.getName()));
    }

    @Override
    public boolean remove(Driver model) {
        validateNotNull(model);
        Driver driver = getByName(model.getName());
        if(driver == null){
            return false;
        }
        this.models.remove(driver);
        return true;
    }

    private void validateNotNull(Driver driver){
        if(driver == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.DRIVER_INVALID);
        }
    }
}
