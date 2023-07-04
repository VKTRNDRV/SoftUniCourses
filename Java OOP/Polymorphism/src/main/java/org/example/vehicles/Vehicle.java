package org.example.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQty;
    protected double fuelConsumptionPerKM;
    protected double extraFuelConsumption;
    protected double tankCapacity;
    protected static DecimalFormat distanceFormatter;
    static {
        distanceFormatter = new DecimalFormat("#.##");
        distanceFormatter.setMinimumFractionDigits(0);
    }

    public double getFuelQty() {
        return fuelQty;
    }

    protected void setFuelQty(double fuelQty) {
        if(fuelQty < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQty = fuelQty;
    }

    public double getFuelConsumptionPerKM() {
        return fuelConsumptionPerKM;
    }

    protected void setFuelConsumptionPerKM(double fuelConsumptionPerKM) {
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
    }

    public String driveDistance(double kilometers){
        double fuelNeeded = kilometers * (fuelConsumptionPerKM + extraFuelConsumption);
        if(fuelNeeded > fuelQty){
            return String.format("%s needs refueling"
                    , this.getClass().getSimpleName());
        }

        fuelQty -= fuelNeeded;
        return String.format("%s travelled %s km"
                , this.getClass().getSimpleName()
                , distanceFormatter.format(kilometers));
    }

    public void refuel(double liters){
        if(liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double potentialFuel = this.getFuelQty() + liters;
        if(potentialFuel > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.setFuelQty(potentialFuel);
    }

    public double getExtraFuelConsumption() {
        return extraFuelConsumption;
    }

    protected void setExtraFuelConsumption(double extraFuelConsumption) {
        this.extraFuelConsumption = extraFuelConsumption;
    }

    public String toString(){
        return String.format("%s: %.2f"
                , this.getClass().getSimpleName()
                , fuelQty);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
