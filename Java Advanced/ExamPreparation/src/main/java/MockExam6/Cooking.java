package MockExam6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] liqInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ingInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for(int b : liqInput){liquids.add(b);}
        for(int c : ingInput){ingredients.push(c);}

        int breadCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int pieCount = 0;

        // iterating until one is empty
        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if(sum == 25){
                breadCount++;

            }else if(sum == 50){
                cakeCount++;

            }else if(sum == 75){
                pastryCount++;

            }else if(sum == 100){
                pieCount++;

            }else{
                ingredient += 3;
                ingredients.push(ingredient);
            }
        }

        // printing output
        if(breadCount > 0
        && cakeCount > 0
        && pastryCount > 0
        && pieCount > 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if(liquids.isEmpty()){
            System.out.print("none\n");
        }else {
            while (liquids.size() > 1){
                System.out.printf("%d, ", liquids.poll());
            }
            System.out.printf("%d\n", liquids.poll());
        }

        System.out.printf("Ingredients left: ");
        if(ingredients.isEmpty()){
            System.out.print("none\n");
        }else {
            while (ingredients.size() > 1){
                System.out.printf("%d, ", ingredients.pop());
            }
            System.out.printf("%d\n", ingredients.pop());
        }

        System.out.printf("Bread: %d\n", breadCount);
        System.out.printf("Cake: %d\n", cakeCount);
        System.out.printf("Fruit Pie: %d\n", pieCount);
        System.out.printf("Pastry: %d", pastryCount);
    }
}
