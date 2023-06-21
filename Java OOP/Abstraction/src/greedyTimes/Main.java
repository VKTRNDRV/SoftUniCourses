package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long goldAmount = 0;
        long gemsAmount = 0;
        long cashAmount = 0;

        // iterate all items in safe
        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i];
            long itemQty = Long.parseLong(safe[i + 1]);


            // check item type
            String itemType = "";
            if (itemName.length() == 3) {
                itemType = "Cash";
            } else if (itemName.toLowerCase().endsWith("gem")) {
                itemType = "Gem";
            } else if (itemName.equalsIgnoreCase("gold")) {
                itemType = "Gold";
            }

            // skip item IF no type or would overfill bag
            if (itemType.equals("")) {
                continue;
            } else if (bagCapacity < goldAmount + gemsAmount + cashAmount + itemQty) {
                continue;
            }

            // skip item IF it would break relative amount rules
            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (itemQty > goldAmount) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + itemQty > goldAmount) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (itemQty > gemsAmount) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + itemQty > gemsAmount) {
                        continue;
                    }
                    break;
            }

            // add item type IF not present
            if (!bag.containsKey(itemType)) {
                bag.put((itemType), new LinkedHashMap<String, Long>());
            }

            // add item name IF not present
            if (!bag.get(itemType).containsKey(itemName)) {
                bag.get(itemType).put(itemName, 0L);
            }

            // add item
            bag.get(itemType).put(itemName, bag.get(itemType).get(itemName) + itemQty);

            // increase itemType amount
            if (itemType.equals("Gold")) {
                goldAmount += itemQty;
            } else if (itemType.equals("Gem")) {
                gemsAmount += itemQty;
            } else if (itemType.equals("Cash")) {
                cashAmount += itemQty;
            }
        }

        // print items
        for (var itemType : bag.entrySet()) {
            Long sumValues = itemType.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", itemType.getKey(), sumValues);

            // sort and print sub items
            itemType.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }
}