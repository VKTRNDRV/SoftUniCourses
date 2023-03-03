import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] usernamesArr = scan.nextLine().split(", ");
        for(String username : usernamesArr){
            boolean isValid = true;
            if(username.length() < 3 || username.length() > 16){isValid = false;}
            for (int i = 0; i < username.length(); i++) {
                char thisChar = username.charAt(i);
                if(!Character.isLetter(thisChar) && !Character.isDigit(thisChar)
                        && !(thisChar == '-' || thisChar == '_')){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                System.out.println(username);
            }
        }
    }
}
