import java.util.Scanner;
import java.text.DecimalFormat;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df2 = new DecimalFormat("#.##");
        float areaSqM = scan.nextFloat();
        float pricePerSqM = 7.61F;
        float discountPriceAdjustment = 0.82F;

        float totalPrice = (areaSqM*pricePerSqM) * discountPriceAdjustment;
        float discount = (areaSqM*pricePerSqM) - totalPrice;

        String totalPriceFormatted = df2.format(totalPrice);
        String discountFormatted = df2.format(discount);

        System.out.printf("The final price is: %s lv.\n", totalPriceFormatted);
        System.out.printf("The discount is: %s lv.", discountFormatted);
    }
}
