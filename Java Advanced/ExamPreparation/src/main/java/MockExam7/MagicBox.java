package MockExam7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        for(int b : line1){firstMagicBox.add(b);}
        for(int c : line2){secondMagicBox.push(c);}

        int totalPrey = 0;

        // iterating until one is empty
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()){
            int firstItem = firstMagicBox.poll();
            int secondItem = secondMagicBox.pop();
            int sum = firstItem + secondItem;

            if(sum % 2 == 0){
                totalPrey += sum;

            }else{
                firstMagicBox.addFirst(firstItem);
                firstMagicBox.add(secondItem);
            }
        }

        if(firstMagicBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if(secondMagicBox.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if(totalPrey >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d", totalPrey);

        }else{
            System.out.printf("Poor prey... Value: %d", totalPrey);
        }
    }
}
