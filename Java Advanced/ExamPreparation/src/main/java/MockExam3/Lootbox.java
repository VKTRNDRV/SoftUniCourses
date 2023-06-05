package MockExam3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //reading input
        int[] inputSecond = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputFirst = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstLootbox = new ArrayDeque<>();
        for(int value : inputSecond){firstLootbox.add(value);}

        ArrayDeque<Integer> secondLootbox = new ArrayDeque<>();
        for(int value : inputFirst){secondLootbox.push(value);}

        int lootTotalSum = 0;

        //iterating until one (or both) lootboxes empty
        while (!firstLootbox.isEmpty() && !secondLootbox.isEmpty()){
            int firstItem = firstLootbox.peek();
            int secondItem = secondLootbox.peek();

            int sum = firstItem + secondItem;

            //performing operations as described
            if(sum % 2 == 0){
                lootTotalSum += sum;
                firstLootbox.poll();
                secondLootbox.pop();

            }else{
                firstLootbox.add(secondLootbox.pop());
            }
        }

        //printing output
        if(firstLootbox.isEmpty()){System.out.println("First lootbox is empty");}
        if(secondLootbox.isEmpty()){System.out.println("Second lootbox is empty");}

        if(lootTotalSum >= 100){
            System.out.printf("Your loot was epic! Value: %d", lootTotalSum);
        }else{
            System.out.printf("Your loot was poor... Value: %d", lootTotalSum);
        }
    }
}
