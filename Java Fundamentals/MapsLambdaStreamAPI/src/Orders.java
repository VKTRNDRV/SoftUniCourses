import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Double> priceMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> quantityMap = new LinkedHashMap<>();

        while (true){
            String[] thisLine = scan.nextLine().split(" ");
            if(thisLine[0].equals("buy")){
                break;
            }
            String thisItem = thisLine[0];
            double thisPrice = Double.parseDouble(thisLine[1]);
            int thisQty = Integer.parseInt(thisLine[2]);

            if(!priceMap.containsKey(thisItem)){
                priceMap.put(thisItem, thisPrice);
                quantityMap.put(thisItem, thisQty);
            }else{
                priceMap.put(thisItem, thisPrice);
                quantityMap.put(thisItem, quantityMap.get(thisItem) + thisQty);
            }
        }

        for(Map.Entry<String, Double> thisEntry : priceMap.entrySet()){
            String thisItem = thisEntry.getKey();
            double totalPrice = thisEntry.getValue() * quantityMap.get(thisItem);
            System.out.printf("%s -> %.2f%n", thisItem, totalPrice);
        }
    }
}
