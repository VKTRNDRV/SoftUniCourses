package pizzaCalories;

public class Dough {
    private String flourType;
    private double flourTypeModifier;
    private String bakingTechnique;
    private double bakingTechniqueModifier;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if(flourType.equals("White")){
            this.flourTypeModifier = 1.5;
        } else if (flourType.equals("Wholegrain")) {
            this.flourTypeModifier = 1.0;
        } else if (flourType.equals("Crispy")) {
            this.flourTypeModifier = 0.9;
        } else if (flourType.equals("Chewy")) {
            this.flourTypeModifier = 1.1;
        } else if (flourType.equals("Homemade")) {
            this.flourTypeModifier = 1.0;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(bakingTechnique.equals("White")){
            this.bakingTechniqueModifier = 1.5;
        } else if (bakingTechnique.equals("Wholegrain")) {
            this.bakingTechniqueModifier = 1.0;
        } else if (bakingTechnique.equals("Crispy")) {
            this.bakingTechniqueModifier = 0.9;
        } else if (bakingTechnique.equals("Chewy")) {
            this.bakingTechniqueModifier = 1.1;
        } else if (bakingTechnique.equals("Homemade")) {
            this.bakingTechniqueModifier = 1.0;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return (weight*2) *
                flourTypeModifier *
                bakingTechniqueModifier;
    }
}
