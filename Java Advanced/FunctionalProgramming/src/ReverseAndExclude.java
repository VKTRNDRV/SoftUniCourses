import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, List<Integer>> reverseList = list -> {
            List<Integer> reversedList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                reversedList.add(list.get(i));
            }

            return reversedList;
        };

        BiFunction<List<Integer>, Integer, List<Integer>> removeDivisibles = (list, num) -> {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) % num == 0){
                    list.remove(i);
                    i--;
                }
            }

            return list;
        };

        String line1 = scanner.nextLine();

        List<Integer> nums = Arrays.stream(line1.split("\\s+"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        int filterNum = Integer.parseInt(scanner.nextLine());

        nums = reverseList.apply(nums);
        nums = removeDivisibles.apply(nums, filterNum);

        for(int n : nums){
            System.out.printf("%d ", n);
        }


    }
}
