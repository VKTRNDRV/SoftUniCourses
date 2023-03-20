import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ArrayDeque<Character> parenthesisStack = new ArrayDeque<>();
        boolean isValid = true;
        for (int i = 0; i < line.length(); i++) {
            char thisChar = line.charAt(i);
            switch (thisChar){
                case '{':
                case '[':
                case '(':
                    parenthesisStack.push(thisChar);
                    break;

                case '}':
                    if(!parenthesisStack.isEmpty()) {
                        if (parenthesisStack.peek().equals('{')) {
                            parenthesisStack.pop();
                        } else {
                            isValid = false;
                        }
                    }else{
                        isValid = false;
                    }
                    break;
                case ']':
                    if(!parenthesisStack.isEmpty()) {
                        if (parenthesisStack.peek().equals('[')) {
                            parenthesisStack.pop();
                        } else {
                            isValid = false;
                        }
                    }else{
                        isValid = false;
                    }
                    break;
                case ')':
                    if(!parenthesisStack.isEmpty()) {
                        if (parenthesisStack.peek().equals('(')) {
                            parenthesisStack.pop();
                        } else {
                            isValid = false;
                        }
                    }else{
                        isValid = false;
                    }
            }
            if(!isValid){
                break;
            }
        }

        if(isValid){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
