package CarSalesman;

public class Car {
    private String model;
    private Engine engine;

    //optional
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color){
        this.setModel(model);
        this.setEngine(engine);
        this.setWeight(weight);
        this.setColor(color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        String carModel = this.getModel();
        String engineModel = this.getEngine().getModel();
        int enginePower = this.getEngine().getPower();

        String engineDisplacement = "n/a";
        if(this.getEngine().getDisplacement() != -1){
            engineDisplacement = String.valueOf(this.getEngine().getDisplacement());
        }

        String engineEfficiency = "n/a";
        if(!this.getEngine().getEfficiency().equals("n/a")){
            engineEfficiency = this.getEngine().getEfficiency();
        }

        String carWeight = "n/a";
        if(this.getWeight() != -1){
            carWeight = String.valueOf(this.getWeight());
        }

        String carColor = this.getColor();

        return String.format("%s:%n", carModel) +
                String.format("%s:%n", engineModel) +
                String.format("Power: %s%n", enginePower) +
                String.format("Displacement: %s%n", engineDisplacement) +
                String.format("Efficiency: %s%n", engineEfficiency) +
                String.format("Weight: %s%n", carWeight) +
                String.format("Color: %s", carColor);
    }
}
