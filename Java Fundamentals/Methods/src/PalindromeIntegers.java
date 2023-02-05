import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            String currentInput = scan.nextLine();
            if(currentInput.equals("END")){
                break;
            }
            int currentNum = Integer.parseInt(currentInput);
            if(isPalindrome(currentNum)){
                System.out.printf("true%n");
            }else{
                System.out.printf("false%n");
            }
        }

    }

    public static boolean isPalindrome(int num){
        String numString = Integer.toString(num);
        StringBuilder reverseNumString = new StringBuilder();

        for (int i = (numString.length()-1); i >= 0; i--) {
            char currentDigit = numString.charAt(i);
            reverseNumString.append(currentDigit);
        }

        return numString.equals(reverseNumString.toString());
    }
}
