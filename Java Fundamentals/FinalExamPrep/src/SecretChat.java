import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        while (true){
            String[] commandArr = scanner.nextLine().split("[:][|][:]");
            if(commandArr[0].equals("Reveal")){break;}
            String command = commandArr[0];
            switch (command){
                case "InsertSpace":
                    int insertIndex = Integer.parseInt(commandArr[1]);
                    message.insert(insertIndex, " ");
                    System.out.println(message.toString());
                    break;

                case "Reverse":
                    String sub = commandArr[1];
                    if(message.toString().contains(sub)){
                        int firstIndex = message.indexOf(sub);
                        message.replace(firstIndex, firstIndex + sub.length(), "");
                        StringBuilder reversed = new StringBuilder(sub);
                        reversed.reverse();
                        message.append(reversed);
                        System.out.println(message);
                    }else{
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String strOld = commandArr[1];
                    String strNew = commandArr[2];
                    String tempStr = message.toString();
                    while (tempStr.contains(strOld)){
                        tempStr = tempStr.replace(strOld, strNew);
                    }
                    message.setLength(0);
                    message.append(tempStr);
                    System.out.println(message.toString());
                    break;
            }
        }

        System.out.printf("You have a new text message: %s", message.toString());
    }
}
