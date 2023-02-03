import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();

        System.out.println(findMiddleChars(inputString));

    }

    public static String findMiddleChars(String input){
        String output = "";

        if(input.length() % 2 == 0){
          output += input.charAt((input.length()/2) - 1);
        }
        output += input.charAt((input.length()/2));

        return output;
    }
}
