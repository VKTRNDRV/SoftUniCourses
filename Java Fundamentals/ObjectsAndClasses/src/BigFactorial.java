import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        BigInteger numFactorial = new BigInteger(String.valueOf(1));

        for (int i = 1; i <= num; i++) {
            numFactorial = numFactorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(numFactorial);
    }
}
