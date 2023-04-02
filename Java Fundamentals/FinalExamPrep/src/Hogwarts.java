import java.util.Scanner;
import java.util.StringJoiner;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spellStr = scanner.nextLine();
        while (true){
            String[] commandArr = scanner.nextLine().split(" ");
            if(commandArr[0].equals("Abracadabra")){break;}
            String command = commandArr[0];
            switch (command){
                case "Abjuration":
                    StringBuilder abjurationTempSB = new StringBuilder(spellStr);
                    for (int i = 0; i < spellStr.length(); i++) {
                        char thisChar = abjurationTempSB.charAt(i);
                        if(Character.isLetter(thisChar) && Character.isLowerCase(thisChar)){
                            char thisNewChar = Character.toUpperCase(thisChar);
                            abjurationTempSB.deleteCharAt(i);
                            abjurationTempSB.insert(i, thisNewChar);
                        }
                    }
                    spellStr = abjurationTempSB.toString();
                    System.out.println(spellStr);
                    break;

                case "Necromancy":
                    StringBuilder necromancyTempSB = new StringBuilder(spellStr);
                    for (int i = 0; i < spellStr.length(); i++) {
                        char thisChar = necromancyTempSB.charAt(i);
                        if(Character.isLetter(thisChar) && Character.isUpperCase(thisChar)){
                            char thisNewChar = Character.toLowerCase(thisChar);
                            necromancyTempSB.deleteCharAt(i);
                            necromancyTempSB.insert(i, thisNewChar);
                        }
                    }
                    spellStr = necromancyTempSB.toString();
                    System.out.println(spellStr);
                    break;

                case "Illusion":
                    int replaceIndex = Integer.parseInt(commandArr[1]);
                    String replaceLetter = commandArr[2];
                    if(replaceIndex >= 0 && replaceIndex < spellStr.length()){
                        StringBuilder tempSB = new StringBuilder(spellStr);
                        tempSB = tempSB.replace(replaceIndex, replaceIndex + 1, replaceLetter);
                        spellStr = tempSB.toString();
                        System.out.println("Done!");
                    }else{
                        System.out.println("The spell was too weak.");
                    }
                    break;

                case "Divination":
                    String oldSubStr = commandArr[1];
                    String replaceSubStr = commandArr[2];
                    if(spellStr.contains(oldSubStr)){
                        spellStr = spellStr.replace(oldSubStr, replaceSubStr);
                        System.out.println(spellStr);
                    }
                    break;

                case "Alteration"://WHAT IF MORE THAN ONE OCCURANCE OF THE REMOVE SUBSTRING IS CONTAINED
                    String removeSubStr = commandArr[1];
                    if(spellStr.contains(removeSubStr)){
                        int startIndex = spellStr.indexOf(removeSubStr);
                        StringBuilder tempSB = new StringBuilder(spellStr);
                        tempSB = tempSB.delete(startIndex, startIndex + removeSubStr.length());
                        spellStr = tempSB.toString();
                        System.out.println(spellStr);
                    }
                    break;

                default:
                    System.out.println("The spell did not work!");
                    break;
            }
        }
    }
}
