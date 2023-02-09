import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputLine = scan.nextLine();
        String[] allArrays = inputLine.split("\\|");

        for (int i = allArrays.length-1; i >= 0; i--) {
            String currentArrayStr = allArrays[i];
            List<String> currentSequence = new ArrayList<>();

            for(int c = 0; c < currentArrayStr.length(); c++){
                if(currentArrayStr.charAt(c) != ' '){
                    currentSequence.add(String.valueOf(currentArrayStr.charAt(c)));
                }
            }

            for (String currentElement : currentSequence) {
                System.out.printf("%s ", currentElement);
            }
        }
    }
}
