package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> riderRepository;

    private Repository<Car> motorcycleRepository;

    private Repository<Race> raceRepository;

    private static final int MIN_DRIVERS_FOR_RACE_START = 3;

//    public ControllerImpl(){
//        this.driverRepository = new DriverRepository();
//        this.carRepository = new CarRepository();
//        this.raceRepository = new RaceRepository();
//    }

    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
        this.riderRepository = riderRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver dr = new DriverImpl(driver);
        riderRepository.add(dr);
        return String.format(OutputMessages
                .DRIVER_CREATED, dr.getName());
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if(type.equals("Muscle")){
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        this.motorcycleRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED,
                car.getClass().getSimpleName(), car.getModel());
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.riderRepository.getByName(driverName);
        Car car = this.motorcycleRepository.getByName(carModel);
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED,
                driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        Driver driver = this.riderRepository.getByName(driverName);
        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED,
                driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        int laps = race.getLaps();
        Collection<Driver> drivers = race.getDrivers();
        if(drivers.size() < MIN_DRIVERS_FOR_RACE_START){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_INVALID,
                    raceName, MIN_DRIVERS_FOR_RACE_START));
        }
        List<Driver> sortedDrivers = drivers.stream().sorted(
                (d1,d2) -> Double.compare(
                d2.getCar().calculateRacePoints(laps),
                d1.getCar().calculateRacePoints(laps)))
                .collect(Collectors.toList());
        this.raceRepository.remove(race);
        StringBuilder output = new StringBuilder();
        Driver winner = sortedDrivers.get(0);
        Driver second = sortedDrivers.get(1);
        Driver third = sortedDrivers.get(2);
        output.append(String.format("Driver %s wins %s race.\n",
                        winner.getName(), raceName))
                .append(String.format("Driver %s is second in %s race.\n",
                        second.getName(), raceName))
                .append(String.format("Driver %s is third in %s race.",
                        third.getName(), raceName));
        return output.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(
                OutputMessages.RACE_CREATED, name);
    }
}
