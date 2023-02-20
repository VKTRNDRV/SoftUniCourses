import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] wordsArr = scan.nextLine().split(" ");
        Random rnd = new Random();

        for(int pos1 = 0; pos1 < wordsArr.length; pos1++){
            int pos2 = rnd.nextInt(wordsArr.length);
            String pos1Element = wordsArr[pos1];
            String pos2Element = wordsArr[pos2];

            wordsArr[pos1] = pos2Element;
            wordsArr[pos2] = pos1Element;
        }

        System.out.println(String.join(System.lineSeparator(), wordsArr));
    }
}