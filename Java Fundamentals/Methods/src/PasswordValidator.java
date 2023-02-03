import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputPassword = scan.nextLine();

        checkPasswordValidity(inputPassword);
    }

    public static void checkPasswordValidity(String password){

        boolean isValid = true;

        int numOfChars = 0;
        boolean isLettersOrDigits = true;
        int numOfDigits = 0;

        for (int i = 0; i < password.length(); i++){
            char currentChar = password.charAt(i);
            numOfChars++;

            if((currentChar >= 48 && currentChar <= 57) ||
               (currentChar >= 65 && currentChar <= 90) ||
               (currentChar >= 97 && currentChar <= 122)){
                //do nothing
            }else{
                isLettersOrDigits = false;
            }

            if(currentChar >= 48 && currentChar <= 57){
                numOfDigits++;
            }
        }

        if(numOfChars < 6 || numOfChars > 10){
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }

        if(!isLettersOrDigits){
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }

        if(numOfDigits < 2){
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }

        if(isValid){
            System.out.println("Password is valid");
        }
    }
}
