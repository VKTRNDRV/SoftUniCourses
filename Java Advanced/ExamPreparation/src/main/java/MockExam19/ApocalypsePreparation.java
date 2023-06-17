package MockExam19;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> allTextiles = new ArrayDeque<>();
        ArrayDeque<Integer> allMedicaments = new ArrayDeque<>();
        for(int t : line1){allTextiles.add(t);}
        for(int m : line2){allMedicaments.push(m);}
        Map<String, Integer> healingItems = new HashMap<>();
        healingItems.put("Patch", 0);
        healingItems.put("Bandage", 0);
        healingItems.put("MedKit", 0);
        int patchesCount = 0;
        int bandagesCount = 0;
        int medkitsCount = 0;

        // iterate until empty
        while (!allTextiles.isEmpty() && !allMedicaments.isEmpty()){
            int textile = allTextiles.poll();
            int medicament = allMedicaments.pop();
            int sum = textile + medicament;

            // perform move
            if(sum > 100){
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
                medicament = sum - 100;
                int nextMedicament = 0;

                // get next medicament IF not empty
                if(!allMedicaments.isEmpty()){
                    nextMedicament = allMedicaments.pop();
                }
                nextMedicament += medicament;
                allMedicaments.push(nextMedicament);

            } else if (sum == 100) {
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
            } else if (sum == 40) {
                healingItems.put("Bandage", healingItems.get("Bandage") + 1);
            } else if (sum == 30) {
                healingItems.put("Patch", healingItems.get("Patch") + 1);

            }else {
                medicament += 10;
                allMedicaments.push(medicament);
            }
        }

        // sorting items by value and name
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(healingItems.entrySet());
        Collections.sort(entries, (entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
        Map<String, Integer> sortedItems = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedItems.put(entry.getKey(), entry.getValue());
        }

        // print output
        if(allMedicaments.isEmpty() && allTextiles.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        }else if (allTextiles.isEmpty()){
            System.out.println("Textiles are empty.");
        }else {
            System.out.println("Medicaments are empty.");
        }
        for(Map.Entry<String, Integer> item : sortedItems.entrySet()){
            int itemsCreated = item.getValue();
            if(itemsCreated > 0){
                System.out.printf("%s - %d\n", item.getKey(), itemsCreated);
            }
        }
        if(!allMedicaments.isEmpty()){
            System.out.print("Medicaments left: ");
            while (allMedicaments.size() > 1){
                System.out.printf("%s, ", allMedicaments.pop());
            }
            System.out.print(allMedicaments.pop());
        }
        if(!allTextiles.isEmpty()){
            System.out.print("Textiles left: ");
            while (allTextiles.size() > 1){
                System.out.printf("%s, ", allTextiles.poll());
            }
            System.out.print(allTextiles.poll());
        }
    }
}
