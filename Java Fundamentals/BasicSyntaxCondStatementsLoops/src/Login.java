import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        StringBuilder sb = new StringBuilder(username);
        sb.reverse();
        String password = sb.toString();
        int incorrectTries = 0;
        boolean isLocked = false;

        while(isLocked == false){
            String currentInput = scan.nextLine();
            if(currentInput.equals(password)){
                System.out.printf("User %s logged in.",username);
                break;
            }else{
                incorrectTries++;
                if(incorrectTries >= 4){
                    isLocked = true;
                    System.out.printf("User %s blocked!",username);
                    break;
                }else{
                    System.out.println("Incorrect password. Try again.");
                }
            }
        }
    }
}
