package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        String name = line1[1];
        int numberOfToppings = Integer.parseInt(line1[2]);
        String flourType = line2[1];
        String bakingTechnique = line2[2];
        double weightInGrams = Double.parseDouble(line2[3]);

        // create pizza
        Pizza pizza = null;
        Dough dough = null;
        try {
            pizza = new Pizza(name, numberOfToppings);
            dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        }catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            return;
        }

        // add toppings
        String toppingType = "";
        try {
            String[] toppingInput = scanner.nextLine().split(" ");
            while (!toppingInput[0].equals("END")){
                toppingType = toppingInput[1];
                double toppingWeight = Double.parseDouble(toppingInput[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);

                toppingInput = scanner.nextLine().split(" ");
            }
        }catch (IllegalStateException e){
            System.out.print(String.format(e.getMessage(), toppingType));
            return;
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
