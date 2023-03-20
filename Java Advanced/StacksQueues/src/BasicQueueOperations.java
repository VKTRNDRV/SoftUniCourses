import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] addPopTestNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value)).toArray();
        int elementsToAdd = addPopTestNums[0];
        int elementsToRemove = addPopTestNums[1];
        int testElement = addPopTestNums[2];
        int[] numsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value)).toArray();
        ArrayDeque<Integer> numsQueue = new ArrayDeque<>();
        for (int i = 0; i < elementsToAdd; i++) {
            numsQueue.add(numsArr[i]);
        }

        for (int i = 0; i < elementsToRemove; i++) {
            numsQueue.poll();
        }

        if(numsQueue.contains(testElement)){
            System.out.println("true");
        }else{
            if(!numsQueue.isEmpty()){
                int minNum = numsQueue.poll();
                while (!numsQueue.isEmpty()){
                    int thisNum = numsQueue.poll();
                    if(thisNum < minNum){minNum = thisNum;}
                }
                System.out.println(minNum);
            }else{
                System.out.println(0);
            }

        }
    }
}
