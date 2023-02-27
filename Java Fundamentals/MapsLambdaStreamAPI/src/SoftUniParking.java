import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalLines = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, String> parkingRegMap = new LinkedHashMap<>();

        for(int i = 1; i <= totalLines; i++){
            String[] thisLine = scan.nextLine().split(" ");
            String thisCommand = thisLine[0];
            String thisUser = thisLine[1];
            switch (thisCommand){
                case "register":
                    String thisPlate = thisLine[2];
                    if(!parkingRegMap.containsKey(thisUser)){
                        parkingRegMap.put(thisUser, thisPlate);
                        System.out.printf("%s registered %s successfully%n", thisUser, thisPlate);
                    }else{
                        System.out.printf("ERROR: already registered with plate number %s%n", thisPlate);
                    }
                    break;
                case "unregister":
                    if(parkingRegMap.containsKey(thisUser)){
                        parkingRegMap.remove(thisUser);
                        System.out.printf("%s unregistered successfully%n", thisUser);
                    }else{
                        System.out.printf("ERROR: user %s not found%n", thisUser);
                    }
                    break;
            }
        }

        for(Map.Entry<String, String> thisEntry : parkingRegMap.entrySet()){
            System.out.printf("%s => %s%n", thisEntry.getKey(), thisEntry.getValue());
        }
    }
}
