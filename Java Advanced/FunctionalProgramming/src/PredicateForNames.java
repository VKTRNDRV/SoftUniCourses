import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        BiPredicate<String, Integer> testLength = (s, n) -> s.length() <= n;

        for(String name : names){
            if(testLength.test(name, testNum)){
               System.out.println(name);
            }
        }


    }
}
