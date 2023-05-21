import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        Function<int[], Integer> findSmallestNum = arr -> {
            int minNum = arr[0];
            for(int num : arr){
                if(num < minNum) {
                    minNum = num;
                }
            }

            return minNum;
        };

        int smallestNum = findSmallestNum.apply(nums);
        System.out.println(smallestNum);

    }
}
