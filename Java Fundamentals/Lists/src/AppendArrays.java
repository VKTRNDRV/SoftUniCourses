import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] allArrays = scan.nextLine().split("\\|");

        ArrayList<String> output = new ArrayList<>();

        for (int i = allArrays.length - 1; i >= 0; i--) {
            String[] currentSequence = allArrays[i].trim().split("\\s+");

            for(String currentElement : currentSequence){
                output.add(currentElement);
            }

            output.remove("");
        }
        System.out.println(String.join(" ", output));
    }
}
