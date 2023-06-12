package MockExam11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> allIngredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessValues = new ArrayDeque<>();
        for(int b : line1){allIngredients.add(b);}
        for(int c : line2){freshnessValues.push(c);}
        int pearSourCount = 0, theHarvestCount = 0, appleHinnyCount = 0, highFashionCount = 0;

        // iterating until empty
        while (!allIngredients.isEmpty() && !freshnessValues.isEmpty()){
            int ingredient = allIngredients.poll();
            int freshness = freshnessValues.pop();

            if (ingredient == 0){
                freshnessValues.push(freshness);
                continue;
            }

            int product = ingredient * freshness;
            if (product == 150){
                pearSourCount++;
            } else if (product == 250) {
                theHarvestCount++;
            } else if (product == 300) {
                appleHinnyCount++;
            } else if (product == 400) {
                highFashionCount++;

            } else {
                ingredient += 5;
                allIngredients.add(ingredient);
            }
        }

        // printing output
        if(pearSourCount > 0
                && theHarvestCount > 0
                && appleHinnyCount > 0
                && highFashionCount > 0){
            System.out.println("It's party time! The cocktails are ready!");
        }else{
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!allIngredients.isEmpty()){
            int sum = allIngredients.poll();
            while (!allIngredients.isEmpty()){
                sum += allIngredients.poll();
            }
            System.out.printf("Ingredients left: %d\n", sum);
        }

        if(appleHinnyCount > 0) {System.out.printf(" # Apple Hinny --> %d\n", appleHinnyCount);}
        if(highFashionCount > 0) {System.out.printf(" # High Fashion --> %d\n", highFashionCount);}
        if(pearSourCount > 0) {System.out.printf(" # Pear Sour --> %d\n", pearSourCount);}
        if(theHarvestCount > 0) {System.out.printf(" # The Harvest --> %d", theHarvestCount);}
    }
}
