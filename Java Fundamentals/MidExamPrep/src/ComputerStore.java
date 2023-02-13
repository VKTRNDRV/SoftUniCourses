import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String currentInput;
        double totalSumNoTax = 0;
        double customerTypePriceAdjustment = 1;

        while(true){
            currentInput = scan.nextLine();
            if(currentInput.equals("special") || currentInput.equals("regular")){
                break;
            }

            double currentPrice = Double.parseDouble(currentInput);
            if(currentPrice <= 0){
                System.out.println("Invalid price!");

            }else{
                totalSumNoTax += currentPrice;
            }
        }

        if(currentInput.equals("special")){
            customerTypePriceAdjustment -= 0.1;
        }

        double finalPrice = totalSumNoTax * 1.2 * customerTypePriceAdjustment;

        if(totalSumNoTax != 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalSumNoTax);
            System.out.printf("Taxes: %.2f$%n", totalSumNoTax * 0.2);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", finalPrice);

        }else{
            System.out.println("Invalid order!");
        }
    }
}
