package fairyShop.models.impl;

import fairyShop.common.ExceptionMessages;
import fairyShop.models.Instrument;

public class InstrumentImpl implements Instrument {

    private int power;

    private static int USE_POWER_DECREMENT = 10;

    public InstrumentImpl(int power){
        if(power < 0){
            throw new IllegalArgumentException(
                    ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.setPower(this.getPower() - USE_POWER_DECREMENT);
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }

    public void setPower(int power) {
        if(power < 0){
            power = 0;
        }
        this.power = power;
    }
}
