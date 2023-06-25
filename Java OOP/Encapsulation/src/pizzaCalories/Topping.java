package pizzaCalories;

public class Topping {
    private String toppingType;

    private double weight;

    private double modifier;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }
    private void setToppingType(String toppingType){
        if(toppingType.equals("Meat")){
            this.modifier = 1.2;
        } else if (toppingType.equals("Veggies")) {
            this.modifier = 0.8;
        } else if (toppingType.equals("Cheese")) {
            this.modifier = 1.1;
        } else if (toppingType.equals("Sauce")) {
            this.modifier = 0.9;
        } else {
            throw new IllegalStateException("Cannot place %s on top of your pizza.");
        }

        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalStateException("%s weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        return (2*weight) * modifier;
    }
}
