import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char char1 = scan.nextLine().charAt(0);
        char char2 = scan.nextLine().charAt(0);

        printCharsFromTo(char1,char2);

    }

    public static void printCharsFromTo(char firstChar, char secondChar){

        int firstIndex;
        int lastIndex;

        if(firstChar <= secondChar) {
            firstIndex = (int) firstChar + 1;
            lastIndex = (int) secondChar - 1;
        }else{
            firstIndex = (int) secondChar + 1;
            lastIndex = (int) firstChar - 1;
        }

        for (int i = firstIndex; i <= lastIndex; i++) {
            char currentChar = (char) i;
            System.out.printf("%c ",currentChar);
        }

    }
}
