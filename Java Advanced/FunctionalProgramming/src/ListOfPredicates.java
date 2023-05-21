import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNum = Integer.parseInt(scanner.nextLine());

        BiPredicate<Integer, Integer> isDivisible = (num, testNum) -> {return num % testNum == 0;};

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 1; i <= maxNum; i++) {
            boolean isValid = true;
            for(int num : numSet){
                if(!isDivisible.test(i, num)){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                System.out.printf("%d ", i);
            }
        }
    }
}
