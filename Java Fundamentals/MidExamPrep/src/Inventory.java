import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> inventoryList = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        while (true){
            String[] currentCommand = scan.nextLine().split(" - ");
            if(currentCommand[0].equals("Craft!")){
                break;
            }
            String command = currentCommand[0];
            String itemString = currentCommand[1];

            switch (command){
                case "Collect":
                    if(!inventoryList.contains(itemString)){
                        inventoryList.add(itemString);
                    }
                    break;

                case "Drop":
                    inventoryList.remove(itemString);
                    break;

                case "Combine Items":
                    String[] itemsArr = itemString.split(":");
                    String oldItem = itemsArr[0];
                    String newItem = itemsArr[1];
                    if(inventoryList.contains(oldItem)){
                        inventoryList.add(inventoryList.indexOf(oldItem) + 1 , newItem);
                    }
                    break;

                case "Renew":
                    if(inventoryList.contains(itemString)){
                        inventoryList.remove(itemString);
                        inventoryList.add(itemString);
                    }
                    break;
            }
        }

        for (int i = 0; i < inventoryList.size(); i++) {
            String currentElement = inventoryList.get(i);
            if(i < inventoryList.size() - 1){
                System.out.printf("%s, ", currentElement);
            }else{
                System.out.print(currentElement);
            }
        }
    }
}
