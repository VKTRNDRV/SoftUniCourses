import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        UnaryOperator<Double> addVAT = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (double price : prices){
            System.out.printf("%.2f%n", addVAT.apply(price));
        }
    }
}
