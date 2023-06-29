package needForSpeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;

    private double fuel;

    private int horsePower;

    public Vehicle(double fuel, int horsePower){
        setFuel(fuel);
        setHorsePower(horsePower);
        setFuelConsumption(Vehicle.DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers){
        double fuelNeeded = kilometers * this.fuelConsumption;
        if(fuelNeeded <= this.fuel){
            this.fuel -= fuelNeeded;
        }
    }
}
