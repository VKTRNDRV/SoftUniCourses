import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] treasureChest = new String[101];
        Arrays.fill(treasureChest, "empty");

        String[] inputItems = scan.nextLine().split("\\|");
        for (int i = 0; i < inputItems.length && i < 101; i++) {
            treasureChest[i] = inputItems[i];
        }

        String[] deletedItems = new String[101];
        Arrays.fill(deletedItems, "empty");
        int deletedItemsCount = 0;

        int itemsInChestCount = 0;
        while(true){
            String[] currentCommand = scan.nextLine().split(" ");
            boolean isEnd = false;

            itemsInChestCount = 0;
            for (int i = 0; i < treasureChest.length; i++) {
                if(!treasureChest[i].equals("empty")){
                    itemsInChestCount++;
                }else{
                    break;
                }
            }

            switch(currentCommand[0]){
                case "Yohoho!":
                    isEnd = true;
                    break;
                case "Loot":
                    for (int currentItem = 1; currentItem < currentCommand.length; currentItem++){

                        //checking if item currentItem is present
                        boolean isPresent = false;
                        for (int i = 0; i < itemsInChestCount + currentCommand.length && i < 101; i++) {
                            if(currentCommand[currentItem].equals(treasureChest[i])){
                                isPresent = true;
                                break;
                            }
                        }
                        //adding currentItem
                        if(!isPresent){
                            for (int i = (itemsInChestCount + currentCommand.length - 1); i >= 0; i--) {
                                if(i != 0){
                                    treasureChest[i] = treasureChest[i-1];
                                }else{
                                    treasureChest[i] = currentCommand[currentItem];
                                }
                            }
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(currentCommand[1]);

                    if(dropIndex < 0 || dropIndex > (itemsInChestCount - 1)) {
                    }else{
                        String tempStr = treasureChest[dropIndex];
                        for (int j = dropIndex; j < itemsInChestCount + 1; j++) {
                            treasureChest[j] = treasureChest[j + 1];
                            if (treasureChest[j].equals("empty")) {
                                treasureChest[j] = tempStr;
                                break;
                            }
                        }
                    }
                    break;
                case "Steal":
                    int itemsStolenCount = Integer.parseInt(currentCommand[1]);
                    if(itemsStolenCount > itemsInChestCount){
                        itemsStolenCount = itemsInChestCount;
                    }
                    for (int i = itemsInChestCount - itemsStolenCount; i < itemsInChestCount; i++) {
                        if(i < itemsInChestCount - 1){
                            deletedItems[deletedItemsCount] = treasureChest[i];
                            deletedItemsCount++;
                        }else{
                            deletedItems[deletedItemsCount] = treasureChest[i];
                            deletedItemsCount++;
                            deletedItems[deletedItemsCount] = "End";
                            deletedItemsCount++;
                        }
                        treasureChest[i] = "empty";

                    }
                    break;
            }
            if(isEnd){
                break;
            }
        }

        if(deletedItemsCount != 0){
            for (int i = 0; i < deletedItemsCount-1; i++) {
                if(!deletedItems[i+1].equals("End")){
                    System.out.printf("%s, ",deletedItems[i]);
                }else{
                    System.out.printf("%s%n",deletedItems[i]);
                    i++;
                }
            }
        }

        if(itemsInChestCount == 0){
            System.out.println("Failed treasure hunt.");
        }else{
            int totalTreasureGain = 0;
            for (int i = 0; i < itemsInChestCount; i++) {
                if(i != (itemsInChestCount - 1)){
                    totalTreasureGain += treasureChest[i].length();
                    //System.out.printf("%s, ", treasureChest[i]);
                }else{
                    totalTreasureGain += treasureChest[i].length();
                    //System.out.printf("%s%n",treasureChest[i]);
                }
            }
            double averageTreasureGain = (double) totalTreasureGain / itemsInChestCount;
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }
    }
}

