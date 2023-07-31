package christmasRaces.entities.drivers;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;

public class DriverImpl implements Driver{

    private String name;

    private Car car;

    private int numberOfWins;

    private boolean canParticipate;


    public DriverImpl(String name){
        setName(name);
        this.numberOfWins = 0;
        updateCanParticipate();
    }


    public void setName(String name) {
        if(name == null || name.trim().length() < 5){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    protected void updateCanParticipate(){
        this.canParticipate = this.car != null;
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
        updateCanParticipate();
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        updateCanParticipate();
        return canParticipate;
    }
}
