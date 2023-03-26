import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<String>> itemsList = new ArrayList<>();
        String inputStr = scanner.nextLine();
        Pattern itemPattern = Pattern.compile
                ("(?<delimiter>[#|])(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = itemPattern.matcher(inputStr);
        while (matcher.find()){
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            String calories = matcher.group("calories");
            List<String> item = new ArrayList<>();
            item.add(itemName);
            item.add(expirationDate);
            item.add(calories);
            itemsList.add(item);
        }
        int totalCalories = 0;
        for(List<String> itemList : itemsList){
            totalCalories += Integer.parseInt(itemList.get(2));
        }

        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        for(List<String> item : itemsList){
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", item.get(0), item.get(1), item.get(2));
        }
    }
}
