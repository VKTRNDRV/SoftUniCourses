package easterRaces.repositories;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;
import easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {

    private Collection<Car> cars;

    public CarRepository(){
        this.cars = new ArrayList<>();
    }
    @Override
    public Car getByName(String name) {
        for(Car car : cars){
            if (car.getModel().equals(name)){
                return car;
            }
        }
        throw new IllegalArgumentException(String.format(
                ExceptionMessages.CAR_NOT_FOUND, name));
    }

    @Override
    public Collection<Car> getAll() {
        return Collections
                .unmodifiableCollection(cars);
    }

    @Override
    public void add(Car model) {
        if(model == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.CAR_INVALID);
        }
        if(containsCarModel(model.getModel())){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.CAR_EXISTS,
                    model.getModel()));
        }
        this.cars.add(model);
    }

    @Override
    public boolean remove(Car model) {
        if(model == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.CAR_INVALID);
        }
        for(Car car : cars){
            if(car.getModel().equals(model.getModel())){
                cars.remove(car);
                return true;
            }
        }
        return false;
    }

    private boolean containsCarModel(String model){
        for(Car car : cars){
            if (car.getModel().equals(model)){
                return true;
            }
        }
        return false;
    }
}
