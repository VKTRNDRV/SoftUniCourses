import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> itemsBought = new ArrayList<>();
        double totalPrice = 0.0;
        Pattern validFormat = Pattern.compile(">>(?<name>\\w+)<<(?<price>\\d+[.]?\\d+)!(?<quantity>\\d+)");
        while (true){
            String line = scan.nextLine();
            if(line.equals("Purchase")){break;}
            Matcher thisOrderMatcher = validFormat.matcher(line);
            if(thisOrderMatcher.find()) {
                String itemName = thisOrderMatcher.group("name");
                double itemPrice = Double.parseDouble(thisOrderMatcher.group("price"));
                int itemQuantity = Integer.parseInt(thisOrderMatcher.group("quantity"));
                itemsBought.add(itemName);
                totalPrice += (itemPrice * itemQuantity);
            }
        }

        System.out.println("Bought furniture:");
        for(String item : itemsBought){
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
