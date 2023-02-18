import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scan.nextLine());

        boolean isPirateShipIntact = true;
        boolean isWarshipIntact = true;
        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("Retire")){
                break;
            }

            switch (currentCommand[0]){
                case "Fire":
                    int fireIndex = Integer.parseInt(currentCommand[1]);
                    int fireDamage = Integer.parseInt(currentCommand[2]);

                    if(fireIndex >= 0 && fireIndex < warShip.size()){
                        int sectionHealth = warShip.get(fireIndex) - fireDamage;
                        warShip.set(fireIndex, sectionHealth);
                        if(sectionHealth <= 0) {
                            isWarshipIntact = false;
                        }
                    }
                    break;

                case "Defend":
                    int defendStartIndex = Math.min(Integer.parseInt(currentCommand[1]), Integer.parseInt(currentCommand[2]));
                    int defendEndIndex = Math.max(Integer.parseInt(currentCommand[1]), Integer.parseInt(currentCommand[2]));
                    int defendDamage = Integer.parseInt(currentCommand[3]);

                    if(defendStartIndex >= 0 && defendEndIndex < pirateShip.size()){
                        for (int i = defendStartIndex; i <= defendEndIndex; i++) {
                            int sectionHealth = pirateShip.get(i) - defendDamage;
                            pirateShip.set(i, sectionHealth);
                            if(sectionHealth <= 0){
                                isPirateShipIntact = false;
                            }
                        }
                    }
                    break;

                case "Repair":
                    int repairIndex = Integer.parseInt(currentCommand[1]);
                    int repairHealth = Integer.parseInt(currentCommand[2]);

                    if(repairIndex >= 0 && repairIndex < pirateShip.size()){
                        int sectionHealth = pirateShip.get(repairIndex) + repairHealth;
                        if(sectionHealth > maxHealth){
                            sectionHealth = maxHealth;
                        }
                        pirateShip.set(repairIndex, sectionHealth);
                    }
                    break;

                case "Status":
                    int sectionsForRepairCount = 0;
                    for(int currentSection : pirateShip){
                        double minHealth = maxHealth*0.2;
                        if(currentSection < minHealth){
                            sectionsForRepairCount++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", sectionsForRepairCount);
                    break;
            }

            if(!isPirateShipIntact || !isWarshipIntact){
                break;
            }
        }

        if(!isPirateShipIntact){
            System.out.print("You lost! The pirate ship has sunken.");

        }else if(!isWarshipIntact){
            System.out.print("You won! The enemy ship has sunken.");

        }else{
            int pirateShipSum = 0;
            for(int currentSection : pirateShip){
                pirateShipSum += currentSection;
            }

            int warshipSum = 0;
            for(int currentSection : warShip){
                warshipSum += currentSection;
            }

            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d", warshipSum);
        }
    }
}
