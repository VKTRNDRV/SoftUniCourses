package MockExam14;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize collections
        Map<String, Integer> swordValues = new HashMap<>();
        swordValues.put("Gladius", 70);
        swordValues.put("Shamshir", 80);
        swordValues.put("Katana", 90);
        swordValues.put("Sabre", 110);
        Map<String, Integer> craftedSwords = new HashMap<>();
        ArrayDeque<Integer> allSteel = new ArrayDeque<>();
        ArrayDeque<Integer> allCarbon = new ArrayDeque<>();

        // read input
        int[] line1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int s : line1){allSteel.add(s);}
        for(int c : line2){allCarbon.push(c);}

        // iterate until empty
        while (!allSteel.isEmpty() && !allCarbon.isEmpty()){
            int steel = allSteel.poll();
            int carbon = allCarbon.pop();
            int sum = steel + carbon;

            // if sum matched -> craft sword
            boolean isSwordCrafted = false;
            for(Map.Entry<String, Integer> sword : swordValues.entrySet()){
                if(sum == sword.getValue()){
                    String swordName = sword.getKey();
                    if(!craftedSwords.containsKey(swordName)){
                        craftedSwords.put(swordName, 0);
                    }
                    craftedSwords.put(swordName, craftedSwords.get(swordName) + 1);
                    isSwordCrafted = true;
                    break;
                }
            }

            // return increased carbon IF no sword crafted
            if(!isSwordCrafted){
                carbon += 5;
                allCarbon.push(carbon);
            }
        }

        // count crafted swords
        int swordsCraftedCount = 0;
        for(Map.Entry<String, Integer> theseSwords : craftedSwords.entrySet()){
            swordsCraftedCount += theseSwords.getValue();
        }

        // print output
        if(swordsCraftedCount > 0){
            System.out.printf("You have forged %d swords.\n", swordsCraftedCount);
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }

        System.out.print("Steel left: ");
        if(allSteel.isEmpty()){
            System.out.println("none");
        }else{
            while (allSteel.size() > 1){
                System.out.printf("%d, ", allSteel.poll());
            }
            System.out.println(allSteel.poll());
        }

        System.out.print("Carbon left: ");
        if(allCarbon.isEmpty()){
            System.out.println("none");
        }else{
            while (allCarbon.size() > 1){
                System.out.printf("%d, ", allCarbon.pop());
            }
            System.out.println(allCarbon.pop());
        }

        if(!craftedSwords.isEmpty()){
            List<String> craftedSwordsNames = new ArrayList<>(craftedSwords
                    .keySet()
                    .stream()
                    .collect(Collectors.toList()));
            craftedSwordsNames.sort(String::compareTo);
            for(String swordName : craftedSwordsNames){
                System.out.printf("%s: %d\n", swordName, craftedSwords.get(swordName));
            }
        }
    }
}
