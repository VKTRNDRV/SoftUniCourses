package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;

    private Repository<Car> carRepository;

    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver d = new DriverImpl(driver);
        driverRepository.add(d);
        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if(type.equals("Sports")){
            car = new SportsCar(model, horsePower);
        }else if(type.equals("Muscle")){
            car = new MuscleCar(model, horsePower);
        }
        this.carRepository.add(car);
        return String.format(OutputMessages
                .CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.driverRepository.getByName(driverName);
        Car car = this.carRepository.getByName(carModel);
        if(driver == null){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
//        if(car == null){
//            throw new IllegalArgumentException(String.format(
//                    ExceptionMessages.CAR_NOT_FOUND, carModel));
//        }
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        if(race == null){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        Driver driver = this.driverRepository.getByName(driverName);
        if(driver == null){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if(race == null){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        List<Driver> drivers = new ArrayList<>(race.getDrivers());
        if(drivers.size() < 3){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        drivers.sort((d1,d2) -> Double.compare(
                d2.getCar().calculateRacePoints(race.getLaps()),
                d1.getCar().calculateRacePoints(race.getLaps())));
        Driver first = drivers.get(0);
        Driver second = drivers.get(1);
        Driver third = drivers.get(2);
        StringBuilder output = new StringBuilder();
        output.append(String.format(OutputMessages
                        .DRIVER_FIRST_POSITION, first.getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages
                        .DRIVER_SECOND_POSITION, second.getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages
                        .DRIVER_THIRD_POSITION, third.getName(), raceName));
        this.raceRepository.remove(race);
        return output.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
