import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        int minAsciiValue = Math.min(firstChar, secondChar) + 1;
        int maxAsciiValue = Math.max(firstChar, secondChar) - 1;
        String charsStr = scanner.nextLine();
        int sumOfAsciiValues = 0;
        for (int i = 0; i < charsStr.length(); i++) {
            char ch = charsStr.charAt(i);
            if(ch >= minAsciiValue && ch <= maxAsciiValue){
                sumOfAsciiValues += ch;
            }
        }
        System.out.println(sumOfAsciiValues);
    }
}
