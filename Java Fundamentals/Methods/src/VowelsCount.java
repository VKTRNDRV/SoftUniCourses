import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int output = getVowelCount(input);

        System.out.println(output);

    }

    public static int getVowelCount(String inputString){
        int vowelCount = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if(currentChar == 'a' || currentChar == 'A' ||
               currentChar == 'e' || currentChar == 'E' ||
               currentChar == 'i' || currentChar == 'I' ||
               currentChar == 'o' || currentChar == 'O' ||
               currentChar == 'u' || currentChar == 'U'){

                vowelCount++;
            }
        }

        return vowelCount;
    }
}
