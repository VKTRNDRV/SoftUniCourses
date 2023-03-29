import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Character> morseMap = new LinkedHashMap<>();
        morseMap.put( ".-", 'A');
        morseMap.put("-...", 'B');
        morseMap.put("-.-.", 'C');
        morseMap.put("-..", 'D');
        morseMap.put(".", 'E');
        morseMap.put("..-.", 'F');
        morseMap.put("--.", 'G');
        morseMap.put("....", 'H');
        morseMap.put("..", 'I');
        morseMap.put(".---", 'J');
        morseMap.put("-.-", 'K');
        morseMap.put(".-..", 'L');
        morseMap.put("--", 'M');
        morseMap.put("-.", 'N');
        morseMap.put("---", 'O');
        morseMap.put(".--.", 'P');
        morseMap.put("--.-", 'Q');
        morseMap.put(".-.", 'R');
        morseMap.put("...", 'S');
        morseMap.put("-", 'T');
        morseMap.put("..-", 'U');
        morseMap.put("...-", 'V');
        morseMap.put(".--", 'W');
        morseMap.put("-..-", 'X');
        morseMap.put("-.--", 'Y');
        morseMap.put("--..", 'Z');
        String[] morseWords = scanner.nextLine().split("\\|");
        for(String morseWord : morseWords){
            morseWord = morseWord.trim();
            String[] morseChars = morseWord.split(" ");
            for(String morseChar : morseChars){
                System.out.print(morseMap.get(morseChar));
            }
            System.out.print(" ");
        }
    }
}
