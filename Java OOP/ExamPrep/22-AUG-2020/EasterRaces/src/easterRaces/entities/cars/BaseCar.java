package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car{

    private String model;

    private int horsePower;

    private double cubicCentimeters;

    private static final int MIN_NAME_LENGTH = 4;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setCubicCentimeters(cubicCentimeters);
        setHorsePower(horsePower);
    }

    public void setModel(String model) {
        if(model == null ||
                model.trim().length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_MODEL,
                    model, MIN_NAME_LENGTH));
        }
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters/horsePower*laps;
    }
}
