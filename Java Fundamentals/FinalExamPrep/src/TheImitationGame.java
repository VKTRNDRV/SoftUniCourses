import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String line = scanner.nextLine();
        while (!line.equals("Decode")){
            String[] currCommand = line.split("\\|");
            switch (currCommand[0]){
                case "Move":
                    int numOfCharsToMove = Integer.parseInt(currCommand[1]);
                    String substringToBeMoved = message.substring(0, numOfCharsToMove);
                    message = message.substring(numOfCharsToMove);
                    message += substringToBeMoved;
                    break;

                case "Insert":
                    int insertIndex = Integer.parseInt(currCommand[1]);
                    String strToBeInserted = currCommand[2];
                    StringBuilder stringBuilder = new StringBuilder(message);
                    stringBuilder.insert(insertIndex, strToBeInserted);
                    message = String.valueOf(stringBuilder);
                    break;

                case "ChangeAll":
                    String substringOld = currCommand[1];
                    String subStringNew = currCommand[2];
                    while(message.contains(substringOld)){
                        message = message.replace(substringOld, subStringNew);
                    }
                    break;
            }
            line = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", message);
    }
}