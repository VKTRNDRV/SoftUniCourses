package fairyShop.models.impl;

public class Sleepy extends BaseHelper{

    private static int SLEEPY_INITIAL_ENERGY = 50;
    private static int SLEEPY_WORK_DECREMENT = 15;
    public Sleepy(String name) {
        super(name, SLEEPY_INITIAL_ENERGY);
    }

    @Override
    public void work(){
        this.setEnergy(this.getEnergy() - SLEEPY_WORK_DECREMENT);
    }
}
