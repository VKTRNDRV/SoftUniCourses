import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstCharIndex = Integer.parseInt(scan.nextLine());
        int lastCharIndex = Integer.parseInt(scan.nextLine());

        for (int i = firstCharIndex; i <= lastCharIndex; i++){
            char currentChar = (char) i;
            String currentOutput = currentChar + " ";
            System.out.printf(currentOutput);
        }
    }
}
