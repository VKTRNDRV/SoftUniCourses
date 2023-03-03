import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            String thisString = scan.nextLine();
            if(thisString.equals("end")){break;}
            StringBuilder output = new StringBuilder();
            for (int i = thisString.length() - 1; i >= 0; i--) {
                char thisChar = thisString.charAt(i);
                output.append(thisChar);
            }
            System.out.printf("%s = %s%n", thisString, output.toString());
        }
    }
}