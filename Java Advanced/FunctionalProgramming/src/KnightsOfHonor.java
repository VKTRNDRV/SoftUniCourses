import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = scanner.nextLine().split("\\s+");

        Consumer<String> printToConsole = s -> System.out.printf("Sir %s%n", s);

        for(String str : inputs){
            printToConsole.accept(str);
        }
    }
}
