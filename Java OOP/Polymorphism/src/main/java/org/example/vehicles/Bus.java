package org.example.vehicles;

public class Bus extends Vehicle{
    protected static final double PASSENGERS_EXTRA_FUEL_CONSUMPTION = 1.4;
    public Bus(double fuelQty, double fuelConsumptionPerKM, double tankCapacity) {
        super.setExtraFuelConsumption
                (PASSENGERS_EXTRA_FUEL_CONSUMPTION);
        setFuelQty(fuelQty);
        setFuelConsumptionPerKM(fuelConsumptionPerKM);
        setTankCapacity(tankCapacity);
    }
    public String driveDistance(double kilometers, boolean isFull){
        if(isFull){
            setExtraFuelConsumption(PASSENGERS_EXTRA_FUEL_CONSUMPTION);
        } else {
            setExtraFuelConsumption(1);
        }

        return super.driveDistance(kilometers);
    }
}
