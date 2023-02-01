import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputStr = scan.nextLine();
        int numOfReps = Integer.parseInt(scan.nextLine());
        String outputStr = repeat(inputStr,numOfReps);

        System.out.println(outputStr);

    }

    public static String repeat(String str, int reps){

        String output = "";
        for (int i = 1; i <= reps; i++) {
            output += str;
        }
        return output;
    }
}
