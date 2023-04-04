import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < 3 && i < numsList.size(); i++) {
            System.out.print(numsList.get(i) + " ");
        }
    }
}
