import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] squareArr = new String[size][size];
        for (int i = 0; i < size; i++) {
            String[] thisLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                squareArr[i][j] = thisLine[j];
            }
        }

        //print first diagonal
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", squareArr[i][i]);
        }
        System.out.println();

        for (int i = size - 1; i >= 0; i--) {
            System.out.printf("%s ", squareArr[i][(size - 1) - i]);
        }
        System.out.println();
    }
}
