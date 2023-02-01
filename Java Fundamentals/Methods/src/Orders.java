import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String itemNameCurrent = scan.nextLine();
        int itemCountCurrent = Integer.parseInt(scan.nextLine());

        double orderPrice = calculateOrderPrice(itemNameCurrent,itemCountCurrent);

        System.out.printf("%.2f",orderPrice);
    }

    public static double calculateOrderPrice(String itemName, int itemCount){

        double itemPrice = 0;

        switch (itemName){
            case "coffee":
                itemPrice = 1.5;
                break;
            case "water":
                itemPrice = 1;
                break;
            case "coke":
                itemPrice = 1.4;
                break;
            case "snacks":
                itemPrice = 2;
                break;
        }
        return itemCount * itemPrice;
    }
}
