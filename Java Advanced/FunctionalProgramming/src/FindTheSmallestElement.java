import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Integer> findSmallestNum = list -> {
            int minNum = list.get(0);
            for(int num : list){
                if(num < minNum) {
                    minNum = num;
                }
            }

            return minNum;
        };

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        int smallestNum = findSmallestNum.apply(nums);

        int smallestNumIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) <= smallestNum){
                smallestNumIndex = i;
            }
        }

        System.out.println(smallestNumIndex);
    }
}
