import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int healthNum = 100;
        int bitcoinNum = 0;

        List<String> roomsList = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        boolean isAlive = true;
        for (int i = 0; i < roomsList.size(); i++) {
            String[] currentRoom = roomsList.get(i).split(" ");

            String command = currentRoom[0];
            int value = Integer.parseInt(currentRoom[1]);

            switch (command){
                case "potion":
                    healthNum += value;
                    if(healthNum > 100){
                        value = 100 - (healthNum - value);
                        healthNum = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", value);
                    System.out.printf("Current health: %d hp.%n", healthNum);
                    break;

                case "chest":
                    bitcoinNum += value;
                    System.out.printf("You found %d bitcoins.%n", value);
                    break;

                default:
                    healthNum -= value;
                    if(healthNum > 0){
                        System.out.printf("You slayed %s.%n", command);
                    }else{
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i + 1);
                        isAlive = false;
                    }
                    break;
            }

            if(!isAlive){
                break;
            }
        }

        if(isAlive){
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", bitcoinNum);
            System.out.printf("Health: %d%n", healthNum);
        }
    }
}
