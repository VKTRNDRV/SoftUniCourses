import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lastCharIndex = Integer.parseInt(scan.nextLine()) + 96;

        for (int i1 = 97; i1 <= lastCharIndex; i1++){
            char firstChar = (char) i1;
            for (int i2 = 97; i2 <= lastCharIndex; i2++){
                char secondChar = (char) i2;
                for (int i3 = 97; i3 <= lastCharIndex; i3++){
                    char thirdChar = (char) i3;
                    System.out.printf("%c%c%c%n",firstChar,secondChar,thirdChar);
                }
            }
        }

    }
}
