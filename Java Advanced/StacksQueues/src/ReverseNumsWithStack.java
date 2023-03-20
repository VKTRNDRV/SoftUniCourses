import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumsWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value)).toArray();

        ArrayDeque<Integer> numsQueue = new ArrayDeque<>();
        for(int num : intArr){
            numsQueue.add(num);
        }

        while (!numsQueue.isEmpty()){
            System.out.printf("%d ", numsQueue.removeLast());
        }
    }
}
