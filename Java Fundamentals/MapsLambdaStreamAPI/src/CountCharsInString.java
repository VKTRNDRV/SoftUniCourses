import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        LinkedHashMap<Character, Integer> charsMap = new LinkedHashMap<>();
        for (int i = 0; i < inputLine.length(); i++) {
            char thisChar = inputLine.charAt(i);
            if (thisChar != ' ') {
                if (!charsMap.containsKey(thisChar)) {
                    charsMap.put(thisChar, 1);
                }else{
                    charsMap.put(thisChar, charsMap.get(thisChar) + 1);
                }
            }
        }

        for(Map.Entry<Character, Integer> thisEntry : charsMap.entrySet()){
            char thisChar = thisEntry.getKey();
            int thisCount = thisEntry.getValue();
            System.out.printf("%c -> %d%n", thisChar, thisCount);
        }
    }
}
