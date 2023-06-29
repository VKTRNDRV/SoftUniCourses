package needForSpeed;

public class Car extends Vehicle{

    private static final double DEFAULT_FUEL_CONSUMPTION = 3;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(Car.DEFAULT_FUEL_CONSUMPTION);
    }
}
