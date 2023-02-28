import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> sidesUsersMap = new LinkedHashMap<>();
        while (true){
            String thisLine = scan.nextLine();
            if(thisLine.equals("Lumpawaroo")){break;}

            String thisCommand = "";
            int thisCommandIndex = 0;
            for(int i = 0; i < thisLine.length() - 2; i++){
                String thisMiniString = String.valueOf(thisLine.charAt(i)) + String.valueOf(thisLine.charAt(i+1));
                if(thisMiniString.equals("| ") || thisMiniString.equals("->")){
                    thisCommand = thisMiniString;
                    thisCommandIndex = i;
                    break;
                }
            }
            String firstString = "";
            for (int i = 0; i < thisCommandIndex - 1; i++) {
                firstString += String.valueOf(thisLine.charAt(i));
            }

            String secondString = "";
            for (int i = thisCommandIndex + 2; i < thisLine.length(); i++) {
                secondString += String.valueOf(thisLine.charAt(i));
            }
            if(secondString.charAt(0) == ' ' && secondString.length() > 1){
                secondString = secondString.substring(1);
            }

            switch (thisCommand){
                case "| ":
                    String thisUser = secondString;
                    String thisSide = firstString;
                    if(!isPresent(sidesUsersMap, thisUser)){
                        if(!sidesUsersMap.containsKey(thisSide)){
                            sidesUsersMap.put(thisSide, new ArrayList<>());
                        }
                        sidesUsersMap.get(thisSide).add(thisUser);
                    }
                    break;

                case "->":
                    thisUser = firstString;
                    thisSide = secondString;
                    if(isPresent(sidesUsersMap, thisUser)){
                        if(!sidesUsersMap.containsKey(thisSide)){
                            sidesUsersMap.put(thisSide, new ArrayList<>());
                        }
                        Map.Entry<String, ArrayList<String>> locationEntry = getEntry(sidesUsersMap, thisUser);
                        String oldSide = locationEntry.getKey();
                        sidesUsersMap.get(oldSide).remove(thisUser);

                    }else{
                       if(!sidesUsersMap.containsKey(thisSide)){
                           sidesUsersMap.put(thisSide, new ArrayList<>());
                       }
                    }
                    sidesUsersMap.get(thisSide).add(thisUser);
                    System.out.printf("%s joins the %s side!%n", thisUser, thisSide);
                    break;
            }
        }

        for(Map.Entry<String, ArrayList<String>> thisEntry : sidesUsersMap.entrySet()){
            if(thisEntry.getValue().size() != 0) {
                System.out.printf("Side: %s, Members: %d%n", thisEntry.getKey(), thisEntry.getValue().size());
                for (String thisUser : thisEntry.getValue()) {
                    System.out.printf("! %s%n", thisUser);
                }
            }
        }
    }

    public static boolean isPresent(LinkedHashMap<String, ArrayList<String>> map, String user){
        for(Map.Entry<String, ArrayList<String>> thisEntry : map.entrySet()){
            for(String thisUser : thisEntry.getValue()){
                if(thisUser.equals(user)){
                    return true;
                }
            }
        }
        return false;
    }
    public static Map.Entry<String, ArrayList<String>> getEntry(LinkedHashMap<String, ArrayList<String>> map, String value){
        for(Map.Entry<String, ArrayList<String>> thisEntry : map.entrySet()){
            if(thisEntry.getValue().contains(value)){
                return thisEntry;
            }
        }
        return null;
    }
}
