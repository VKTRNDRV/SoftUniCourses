package MockExam4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] lilliesInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] rosesInput = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> lilliesStack = new ArrayDeque<>();
        for(int value : lilliesInput){lilliesStack.push(value);}

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        for(int value : rosesInput){rosesQueue.add(value);}

        int wreathsCount = 0;
        int leftoverFlowers = 0;

        // iterating until one (or both) stacks are empty
        while(!lilliesStack.isEmpty() && !rosesQueue.isEmpty()){
            int lilliesBunch = lilliesStack.pop();
            int rosesBunch = rosesQueue.poll();

            int sum = lilliesBunch + rosesBunch;

            if(sum < 15){
                leftoverFlowers += sum;
                continue;

            } else if (sum == 15) {
                wreathsCount++;

            }else{
                lilliesBunch -= 2;
                lilliesStack.push(lilliesBunch);
                rosesQueue.addFirst(rosesBunch);
            }
        }

        // adding wreaths from additional flowers
        wreathsCount += (leftoverFlowers / 15);

        // printing output
        if(wreathsCount >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathsCount);
        }


    }
}
