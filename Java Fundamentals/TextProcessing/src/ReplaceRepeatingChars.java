import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder inputString = new StringBuilder();
        inputString.append(scan.nextLine());
        for (int i = 0; i < inputString.length() - 1; i++) {
            char thisChar = inputString.charAt(i);
            if(thisChar == inputString.charAt(i+1)){
                inputString.deleteCharAt(i+1);
                i -= 1;
            }
        }

        System.out.println(inputString.toString());
    }
}
