import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsMax = scanner.nextInt();
        int colsMax = scanner.nextInt();
        for(int row = 0; row < rowsMax; row++){
            char rowChar = (char) (row + 97);
            for (int col = 0; col < colsMax; col++) {
                char colChar = (char) (row + col + 97);
                System.out.printf("%c%c%c ", rowChar, colChar, rowChar);
            }
            System.out.println();
        }
    }
}
