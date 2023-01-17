import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfOrders = Integer.parseInt(scan.nextLine());
        double totalPrice = 0;

        for(int i = 1; i <= numOfOrders*3; i+=3){
            double currentCapsulePrice = Double.parseDouble(scan.nextLine());
            int currentOrderDays = Integer.parseInt(scan.nextLine());
            int currentCapsuleCount = Integer.parseInt(scan.nextLine());
            double currentOrderPrice = currentCapsulePrice * (currentCapsuleCount * currentOrderDays);
            totalPrice += currentOrderPrice;

            System.out.printf("The price for the coffee is: $%.2f%n", currentOrderPrice);
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
