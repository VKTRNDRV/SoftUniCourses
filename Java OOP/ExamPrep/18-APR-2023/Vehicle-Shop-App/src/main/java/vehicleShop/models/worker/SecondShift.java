package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    public SecondShift(String name) {
        super(name, 70);
    }

    @Override
    public void working() {
        decrementStrength(5);
        super.working();
    }
}
