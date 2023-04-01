import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> townsMap = new LinkedHashMap<>();
        while (true){
            String[] townArr = scanner.nextLine().split("\\|\\|");
            if(townArr[0].equals("Sail")){break;}
            String townName = townArr[0];
            int townPopulation = Integer.parseInt(townArr[1]);
            int townGold = Integer.parseInt(townArr[2]);
            if(!townsMap.containsKey(townName)){
                townsMap.put(townName, new ArrayList<>());
                townsMap.get(townName).add(townPopulation);
                townsMap.get(townName).add(townGold);
            }else{
                townsMap.get(townName).set(0, townPopulation + townsMap.get(townName).get(0));
                townsMap.get(townName).set(1, townGold + townsMap.get(townName).get(1));
            }
        }

        while (true){
            String[] commandArr = scanner.nextLine().split("=>");
            if(commandArr[0].equals("End")){break;}
            String command = commandArr[0];
            String townName = commandArr[1];
            switch (command){
                case "Plunder":
                    int peopleKilled = Integer.parseInt(commandArr[2]);
                    int goldPlundered = Integer.parseInt(commandArr[3]);
                    int townPopulation = townsMap.get(townName).get(0);
                    int townGold = townsMap.get(townName).get(1);
                    if(townPopulation - peopleKilled > 0 && townGold - goldPlundered > 0){
                        townsMap.get(townName).set(0, townsMap.get(townName).get(0) - peopleKilled);
                        townsMap.get(townName).set(1, townsMap.get(townName).get(1) - goldPlundered);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                        , townName, goldPlundered, peopleKilled);
                    }else{
                        peopleKilled = Math.min(peopleKilled, townPopulation);
                        goldPlundered = Math.min(goldPlundered, townGold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n"
                                , townName, goldPlundered, peopleKilled);
                        townsMap.remove(townName);
                        System.out.printf("%s has been wiped off the map!%n", townName);
                    }
                    break;

                case "Prosper":
                    int goldAdded = Integer.parseInt(commandArr[2]);
                    int goldAvailable = townsMap.get(townName).get(1);
                    if(goldAdded >= 0){
                        townsMap.get(townName).set(1, goldAdded + goldAvailable);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                        , goldAdded, townName, goldAdded + goldAvailable);
                    }else{
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
        }

        if(!townsMap.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townsMap.size());
            for (Map.Entry<String, List<Integer>> townEntry : townsMap.entrySet()) {
                String name = townEntry.getKey();
                int population = townEntry.getValue().get(0);
                int gold = townEntry.getValue().get(1);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", name, population, gold);
            }
        }else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
