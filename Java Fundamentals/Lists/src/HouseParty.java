import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scan.nextLine());

        List<String> guestList = new ArrayList<>();

        for (int i = 1; i <= commandsCount; i++) {
            String[] inputCommand = scan.nextLine().split(" ");
            String currentName = inputCommand[0];
            String currentCommand = inputCommand[2];

            boolean containsName = guestList.contains(currentName);

            switch (currentCommand){
                case "going!":
                    if(!containsName){
                        guestList.add(currentName);
                    }else{
                        System.out.printf("%s is already in the list!%n", currentName);
                    }
                    break;

                case "not":
                    if(containsName){
                        guestList.remove(currentName);
                    }else{
                        System.out.printf("%s is not in the list!%n", currentName);
                    }
                    break;
            }
        }

        for (String currentName : guestList){
            System.out.println(currentName);
        }
    }
}
