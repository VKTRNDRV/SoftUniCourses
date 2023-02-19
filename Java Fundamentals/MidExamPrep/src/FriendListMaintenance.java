import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> friendsList = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        int blacklistedCount = 0;
        int lostCount = 0;

        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("Report")){
                break;
            }

            switch (currentCommand[0]){
                case "Blacklist":
                    String blacklistName = currentCommand[1];
                    if(friendsList.contains(blacklistName)){
                        int blacklistIndex = friendsList.indexOf(blacklistName);
                        friendsList.set(blacklistIndex, "Blacklisted");
                        System.out.printf("%s was blacklisted.%n", blacklistName);
                        blacklistedCount++;

                    }else{
                        System.out.printf("%s was not found.%n", blacklistName);
                    }
                    break;

                case "Error":
                    int errorIndex = Integer.parseInt(currentCommand[1]);
                    if(errorIndex >= 0 && errorIndex < friendsList.size()){
                        if(!friendsList.get(errorIndex).equals("Blacklisted")
                                && !friendsList.get(errorIndex).equals("Lost")){

                            String errorName = friendsList.get(errorIndex);
                            friendsList.set(errorIndex, "Lost");
                            System.out.printf("%s was lost due to an error.%n", errorName);
                            lostCount++;
                        }
                    }
                    break;

                case "Change":
                    int changeIndex = Integer.parseInt(currentCommand[1]);
                    String changeNameNew = currentCommand[2];
                    if(changeIndex >= 0 && changeIndex < friendsList.size()){
                        if(!friendsList.get(changeIndex).equals("Blacklisted")
                                && !friendsList.get(changeIndex).equals("Lost")){ //should blacklisted and lost names be changed??

                            String changeNameOld = friendsList.get(changeIndex);
                            friendsList.set(changeIndex, changeNameNew);
                            System.out.printf("%s changed his username to %s.%n", changeNameOld, changeNameNew);
                        }
                    }
                    break;
            }
        }

        System.out.printf("Blacklisted names: %d%n", blacklistedCount);
        System.out.printf("Lost names: %d%n", lostCount);
        for(String currentName : friendsList){
            System.out.print(currentName + " ");
        }
    }
}
