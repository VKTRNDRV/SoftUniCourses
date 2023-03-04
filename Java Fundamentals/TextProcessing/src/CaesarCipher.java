import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        for (int i = 0; i < inputString.length(); i++) {
            char thisChar = inputString.charAt(i);
            System.out.printf("%c", thisChar + 3);
        }
    }
}
