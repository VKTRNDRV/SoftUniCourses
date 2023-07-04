package org.example.vehicles;

public class Truck extends Vehicle{

    protected static final double TRUCK_SUMMER_EXTRA_FUEL_CONSUMPTION = 1.6;

    public static final double REFUEL_LOSS_MULTIPLIER = 0.95;

    public Truck(double fuelQty, double fuelConsumptionPerKM, double tankCapacity) {
        super.setExtraFuelConsumption
                (TRUCK_SUMMER_EXTRA_FUEL_CONSUMPTION);
        setFuelQty(fuelQty);
        setFuelConsumptionPerKM(fuelConsumptionPerKM);
        setTankCapacity(tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        liters *= REFUEL_LOSS_MULTIPLIER;
        super.refuel(liters);
    }
}
