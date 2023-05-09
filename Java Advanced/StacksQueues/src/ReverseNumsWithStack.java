import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumsWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int n : nums){
            stack.push(n);
        }

        while (!stack.isEmpty()){
            System.out.printf("%d ", stack.pop());
        }
    }
}
