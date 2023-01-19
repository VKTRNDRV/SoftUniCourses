import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numString = new String(scan.nextLine());
        int sum = 0;

        for (int d = 0; d < numString.length(); d++) {
            int currentDigit = Integer.parseInt(String.valueOf(numString.charAt(d)));
            sum += currentDigit;
        }

        System.out.println(sum);
    }
}
