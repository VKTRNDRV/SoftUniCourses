package christmasRaces.repositories;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {

    private Collection<Car> models;

    public CarRepository(){
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        for(Car car : models){
            if (car.getModel().equals(name)){
                return car;
            }
        }
        return null;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Car model) {
        validateNotNull(model);
        if(getByName(model.getModel()) == null){
            models.add(model);
            return;
        }
        throw new IllegalArgumentException(String.format(
                ExceptionMessages.CAR_EXISTS, model.getModel()));
    }

    @Override
    public boolean remove(Car model) {
        validateNotNull(model);
        Car car = getByName(model.getModel());
        if(car == null){
            return false;
        }
        models.remove(model);
        return true;
    }

    private void validateNotNull(Car car){
        if(car == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.CAR_INVALID);
        }
    }
}
