import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfInputs = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal(0);
        for (int i = 1; i <= numOfInputs; i++){
            BigDecimal currentInput = new BigDecimal(scan.nextLine());
            sum = sum.add(currentInput);
        }
        System.out.println(sum);
    }
}
