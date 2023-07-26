package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar{

    private static final int CUBIC_CM = 5000;
    private static final int MIN_VALID_HORSEPOWER = 400;
    private static final int MAX_VALID_HORSEPOWER = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CM);
        if(horsePower < MIN_VALID_HORSEPOWER ||
                horsePower > MAX_VALID_HORSEPOWER){
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
    }
}
