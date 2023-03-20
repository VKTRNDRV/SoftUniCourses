import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] addPopTestNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value)).toArray();
        int elementsToAdd = addPopTestNums[0];
        int elementsToPop = addPopTestNums[1];
        int testElement = addPopTestNums[2];
        int[] numsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value)).toArray();
        ArrayDeque<Integer> numsStack = new ArrayDeque<>();
        for (int i = 0; i < elementsToAdd; i++) {
            numsStack.push(numsArr[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            numsStack.pop();
        }

        if(numsStack.contains(testElement)){
            System.out.println("true");
        }else{
            if(!numsStack.isEmpty()){
                int minNum = numsStack.pop();
                while (!numsStack.isEmpty()){
                    int thisNum = numsStack.pop();
                    if(thisNum < minNum){minNum = thisNum;}
                }
                System.out.println(minNum);
            }else{
                System.out.println(0);
            }

        }
    }
}
