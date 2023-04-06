import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lowerUpperBound = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        Predicate<Integer> tester = createTester(command);
        int lowerBound = Math.min(lowerUpperBound[0], lowerUpperBound[1]);
        int higherBound = Math.max(lowerUpperBound[0], lowerUpperBound[1]);
        for (int i = lowerBound; i <= higherBound; i++) {
            if(tester.test(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static Predicate<Integer> createTester(String command){
        Predicate<Integer> tester = null;
        switch (command){
            case "even":
                tester = x -> x % 2 == 0;
                break;
                
            case "odd":
                tester = x -> x % 2 != 0;
                break;
        }
        
        return tester;
    }
}
