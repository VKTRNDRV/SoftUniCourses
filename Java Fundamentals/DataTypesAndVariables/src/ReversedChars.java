import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        char thirdChar = scan.nextLine().charAt(0);

        String outputString = "";
        outputString = outputString.concat(Character.toString(thirdChar)) + " ";
        outputString = outputString.concat(Character.toString(secondChar)) + " ";
        outputString = outputString.concat(Character.toString(firstChar));

        System.out.printf("%s",outputString);
    }
}
