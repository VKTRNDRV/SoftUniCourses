package easterRaces.entities.drivers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;

public class DriverImpl implements Driver{

    private String name;

    private Car car;

    private int numberOfWins;

    private boolean canParticipate;

    private static final int MIN_NAME_LENGTH = 5;

    public DriverImpl(String name){
        setName(name);
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    public void setName(String name){
        if(name == null ||
                name.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_NAME,
                    name,  MIN_NAME_LENGTH));
        }
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if(car == null){
            throw new IllegalArgumentException(
                    ExceptionMessages.CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.car != null;
    }
}
