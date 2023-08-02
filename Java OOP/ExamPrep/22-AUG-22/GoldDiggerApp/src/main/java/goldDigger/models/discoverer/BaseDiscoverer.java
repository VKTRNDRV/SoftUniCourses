package goldDigger.models.discoverer;

import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer{

    private String name;

    private double energy;

    private Museum museum;

    public BaseDiscoverer(String name, double energy){
        setName(name);
        setEnergy(energy);
        this.museum = new BaseMuseum();
        setDigEnergyDecrease(15);
    }


    private double digEnergyDecrease;

    protected void setDigEnergyDecrease(double digEnergyDecrease) {
        this.digEnergyDecrease = digEnergyDecrease;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setEnergy(double energy) {
        if(energy < 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canDig() {
        return energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return museum;
    }

    @Override
    public void dig() {
        this.energy -= this.digEnergyDecrease;
        if(this.energy < 0){
            this.energy = 0;
        }
    }
}
