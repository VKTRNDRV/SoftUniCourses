import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsArrStr = scanner.nextLine().split(", ");
        Function<String, Integer> parser = s -> Integer.parseInt(s);
        int sum = 0;
        for(String s : numsArrStr){
            sum += parser.apply(s);
        }

        System.out.println("Count = " + numsArrStr.length);
        System.out.println("Sum = " + sum);

    }
}
