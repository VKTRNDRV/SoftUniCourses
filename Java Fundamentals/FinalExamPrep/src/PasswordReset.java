import java.util.Scanner;
import java.util.StringJoiner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwordStr = scanner.nextLine();
        while (true){
            String[] commandArr = scanner.nextLine().split(" ");
            if(commandArr[0].equals("Done")){break;}
            String command = commandArr[0];
            switch (command){
                case "TakeOdd":
                    StringBuilder passwordNewSB = new StringBuilder();
                    for (int i = 1; i < passwordStr.length(); i+=2) {
                        char thisChar = passwordStr.charAt(i);
                        passwordNewSB.append(thisChar);
                    }
                    passwordStr = passwordNewSB.toString();
                    System.out.println(passwordStr);
                    break;

                case "Cut":
                    int subStrIndex = Integer.parseInt(commandArr[1]);
                    int subStrLength = Integer.parseInt(commandArr[2]);
                    StringBuilder tempSB = new StringBuilder(passwordStr);
                    passwordStr = tempSB.delete(subStrIndex, subStrIndex + subStrLength).toString();
                    System.out.println(passwordStr);
                    break;

                case "Substitute":
                    String subStrOld = commandArr[1];
                    String subStrNew = commandArr[2];
                    if(passwordStr.contains(subStrOld)){
                        passwordStr = passwordStr.replace(subStrOld, subStrNew);
                        System.out.println(passwordStr);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
        }

        System.out.printf("Your password is: %s", passwordStr);
    }
}
