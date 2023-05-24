package CarSalesman;

public class Engine {
    private String model;
    private int power;

    //optional
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency){
        this.setModel(model);
        this.setPower(power);
        this.setDisplacement(displacement);
        this.setEfficiency(efficiency);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
