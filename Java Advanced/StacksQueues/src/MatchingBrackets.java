import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expressionStr = scanner.nextLine();
        ArrayDeque<Integer> subexpressionsStack = new ArrayDeque<>();
        for (int i = 0; i < expressionStr.length(); i++) {
            char thisChar = expressionStr.charAt(i);
            switch (thisChar){
                case '(':
                    subexpressionsStack.push(i);
                    break;
                case ')':
                    int startIndex = subexpressionsStack.pop();
                    int endIndex = i+1;
                    System.out.println(expressionStr.substring(startIndex, endIndex));
                    break;
                default:
            }
        }
    }
}
