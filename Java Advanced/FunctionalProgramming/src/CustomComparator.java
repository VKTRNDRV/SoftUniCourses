import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Comparator<? super Integer> customComparator = (n1, n2) -> {
            if(n1 % 2 == 0 && n2 % 2 != 0){
                return -1;

            }else if(n1 % 2 != 0 && n2 % 2 == 0){
                return 1;

            }else if(n1 < n2){
                return -1;

            }else if(n2 > n1){
                return 1;
            }

            return 0;
        };

        nums.stream().sorted(customComparator).forEach(s -> System.out.printf("%s ", s));
    }
}
