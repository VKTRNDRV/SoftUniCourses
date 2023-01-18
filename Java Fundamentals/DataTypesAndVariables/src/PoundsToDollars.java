import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inputGBP = Double.parseDouble(scan.nextLine());
        double exchRateGBPtoUSD = 1.36;
        double outputUSD = inputGBP * exchRateGBPtoUSD;

        System.out.printf("%.3f",outputUSD);
    }
}
