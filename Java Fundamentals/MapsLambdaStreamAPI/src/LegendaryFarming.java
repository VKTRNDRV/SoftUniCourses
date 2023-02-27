import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> itemsMap = new LinkedHashMap<>();
        itemsMap.put("shards", 0);
        itemsMap.put("fragments", 0);
        itemsMap.put("motes", 0);

        boolean isShadowmourneObtained = false;
        boolean isValanyrObtained = false;
        boolean isDragonwrathObtained = false;
        while (true){
            String[] thisLine = scan.nextLine().split(" ");
            if(thisLine.length == 0){
                break;
            }

            for(int i = 0; i < thisLine.length - 1; i+=2){
                String thisItem = thisLine[i+1].toLowerCase();
                int thisQty = Integer.parseInt(thisLine[i]);
                if(!itemsMap.containsKey(thisItem)){
                    itemsMap.put(thisItem, thisQty);
                }else{
                    itemsMap.put(thisItem, itemsMap.get(thisItem) + thisQty);
                }

                if(itemsMap.get("shards") >= 250){
                    isShadowmourneObtained = true;
                    itemsMap.put("shards", itemsMap.get("shards") - 250);
                    System.out.println("Shadowmourne obtained!");
                    break;
                } else if (itemsMap.get("fragments") >= 250) {
                    isValanyrObtained = true;
                    itemsMap.put("fragments", itemsMap.get("fragments") - 250);
                    System.out.println("Valanyr obtained!");
                    break;
                } else if (itemsMap.get("motes") >= 250) {
                    isDragonwrathObtained = true;
                    itemsMap.put("motes", itemsMap.get("motes") - 250);
                    System.out.println("Dragonwrath obtained!");
                    break;
                }
            }

            if(isShadowmourneObtained || isValanyrObtained || isDragonwrathObtained){
                break;
            }
        }

        for(Map.Entry<String, Integer> thisEntry : itemsMap.entrySet()){
            String name = thisEntry.getKey();
            int qty = thisEntry.getValue();
            System.out.printf("%s: %d%n", name, qty);
        }
    }
}
