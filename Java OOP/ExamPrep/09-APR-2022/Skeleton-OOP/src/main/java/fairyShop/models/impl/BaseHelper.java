package fairyShop.models.impl;

import fairyShop.common.ExceptionMessages;
import fairyShop.models.Helper;
import fairyShop.models.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class BaseHelper implements Helper {

    private String name;

    private int energy;

    private Collection<Instrument> instruments;

    private static int WORK_DECREMENT = 10;

    protected BaseHelper(String name, int energy){
        setName(name);
        setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        if(energy < 0){
            energy = 0;
        }
        this.energy = energy;
    }

    @Override
    public void work() {
        this.setEnergy(this.getEnergy() - WORK_DECREMENT);
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.getEnergy() > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return Collections
                .unmodifiableCollection(this.instruments);
    }
}
