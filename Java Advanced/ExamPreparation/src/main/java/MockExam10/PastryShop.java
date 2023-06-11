package MockExam10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> allLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> allIngredients = new ArrayDeque<>();
        for(int b : line1){allLiquids.add(b);}
        for(int c : line2){allIngredients.push(c);}
        int biscuitCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;

        // iterating until empty
        while (!allLiquids.isEmpty() && !allIngredients.isEmpty()){
            int liquid = allLiquids.poll();
            int ingredient = allIngredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25){
                biscuitCount++;
            } else if (sum == 50) {
                cakeCount++;
            } else if (sum == 75) {
                pastryCount++;
            } else if (sum == 100) {
                pieCount++;

            } else {
                ingredient += 3;
                allIngredients.push(ingredient);
            }
        }

        // printing output
        if(biscuitCount > 0
        && cakeCount > 0
        && pastryCount > 0
        && pieCount > 0){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else{
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if(allLiquids.isEmpty()){
            System.out.println("none");
        }else{
            while (allLiquids.size() > 1){
                System.out.printf("%d, ", allLiquids.poll());
            }
            System.out.println(allLiquids.poll());
        }

        System.out.print("Ingredients left: ");
        if(allIngredients.isEmpty()){
            System.out.println("none");
        }else{
            while (allIngredients.size() > 1){
                System.out.printf("%d, ", allIngredients.pop());
            }
            System.out.println(allIngredients.pop());
        }

        System.out.printf("Biscuit: %d\n", biscuitCount);
        System.out.printf("Cake: %d\n", cakeCount);
        System.out.printf("Pie: %d\n", pieCount);
        System.out.printf("Pastry: %d", pastryCount);

    }
}
