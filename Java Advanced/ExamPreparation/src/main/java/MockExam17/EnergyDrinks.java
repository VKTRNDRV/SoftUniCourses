package MockExam17;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> allCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> allDrinks = new ArrayDeque<>();
        for(int c : line1){allCaffeine.push(c);}
        for(int d : line2){allDrinks.add(d);}
        int totalCaffeineConsumed = 0;

        // iterating until empty
        while (!allCaffeine.isEmpty() && !allDrinks.isEmpty()){
            int caffeine = allCaffeine.pop();
            int drink = allDrinks.poll();
            int product = caffeine * drink;

            if(product + totalCaffeineConsumed <= 300){
                totalCaffeineConsumed += product;

            }else {
                allDrinks.add(drink);
                totalCaffeineConsumed -= 30;
                if(totalCaffeineConsumed < 0){
                    totalCaffeineConsumed = 0;
                }
            }
        }

        // print output
        if(!allDrinks.isEmpty()){
            System.out.print("Drinks left: ");
            while (allDrinks.size() > 1){
                System.out.printf("%d, ", allDrinks.pop());
            }
            System.out.printf("%d\n", allDrinks.pop());
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeineConsumed);

    }
}
