import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = scanner.nextLine().split("\\s+");

        Consumer<String> printToConsole = s -> System.out.println(s);

        for(String str : inputs){
            printToConsole.accept(str);
        }
    }
}
