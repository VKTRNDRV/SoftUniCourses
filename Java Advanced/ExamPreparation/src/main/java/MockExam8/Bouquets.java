package MockExam8;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> allTulips = new ArrayDeque<>();
        ArrayDeque<Integer> allDaffodils = new ArrayDeque<>();
        for(int b : line1){allTulips.push(b);}
        for(int c : line2){allDaffodils.add(c);}

        int bouquetsCrafted = 0;
        int leftoverFlowers = 0;

        // iterating until one is empty
        while (!allTulips.isEmpty() && !allDaffodils.isEmpty()){
            int tulips = allTulips.peek();
            int daffodils = allDaffodils.peek();
            int sum = tulips + daffodils;

            if(sum > 15){
                tulips -= 2;
                allTulips.pop();
                allTulips.push(tulips);

            } else if (sum == 15) {
                allTulips.pop();
                allDaffodils.poll();
                bouquetsCrafted++;

            } else {
                allTulips.pop();
                allDaffodils.poll();
                leftoverFlowers += sum;
            }
        }

        // using leftover flowers
        bouquetsCrafted += (leftoverFlowers / 15);

        //printing output
        if(bouquetsCrafted >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCrafted);

        }else{
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCrafted);
        }
    }
}
