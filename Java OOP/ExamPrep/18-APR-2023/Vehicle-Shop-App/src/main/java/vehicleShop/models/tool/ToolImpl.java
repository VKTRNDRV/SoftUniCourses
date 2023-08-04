package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool{

    private int power;

    public ToolImpl(int power){
        setPower(power);
    }


    protected void setPower(int power) {
        if(power < 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        this.power -= 5;
        if(this.power < 0){
            power = 0;
        }
    }

    @Override
    public boolean isUnfit() {
        return (this.power <= 0);
    }
}
