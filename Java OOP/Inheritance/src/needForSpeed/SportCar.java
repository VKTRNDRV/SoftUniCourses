package needForSpeed;

public class SportCar extends Car{
    private static final double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(SportCar.DEFAULT_FUEL_CONSUMPTION);
    }
}
