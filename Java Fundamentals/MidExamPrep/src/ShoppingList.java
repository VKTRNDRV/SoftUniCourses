import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scan.nextLine().split("!"))
                .collect(Collectors.toList());

        while(true){
            String currentString = scan.nextLine();
            if(currentString.equals("Go Shopping!")){
                break;
            }
            String[] currentCommand = currentString.split(" ");

            String itemName = currentCommand[1];

            switch(currentCommand[0]){
                case "Urgent":
                    if(!shoppingList.contains(itemName)){
                        shoppingList.add(0, itemName);
                    }
                    break;

                case "Unnecessary":
                    if(shoppingList.contains(itemName)){
                        int removeIndex = shoppingList.indexOf(itemName);
                        shoppingList.remove(removeIndex);
                    }
                    break;

                case "Correct":
                    if(shoppingList.contains(itemName)){
                        String itemAdded = currentCommand[2];
                        int correctionIndex = shoppingList.indexOf(itemName);
                        shoppingList.set(correctionIndex, itemAdded);
                    }
                    break;

                case "Rearrange":
                    if(shoppingList.contains(itemName)){
                        shoppingList.remove(itemName);
                        shoppingList.add(itemName);
                    }
                    break;
            }
        }

        for (int i = 0; i < shoppingList.size(); i++) {
            String currentItem = shoppingList.get(i);
            if(i < shoppingList.size() - 1){
                System.out.printf("%s, ", currentItem);
            }else{
                System.out.print(currentItem);
            }
        }

    }
}
