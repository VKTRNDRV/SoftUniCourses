package org.example.vehicles;

public class Car extends Vehicle{
    protected static final double CAR_SUMMER_EXTRA_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQty, double fuelConsumptionPerKM, double tankCapacity) {
        super.setExtraFuelConsumption
                (CAR_SUMMER_EXTRA_FUEL_CONSUMPTION);
        setFuelQty(fuelQty);
        setFuelConsumptionPerKM(fuelConsumptionPerKM);
        setTankCapacity(tankCapacity);
    }
}
