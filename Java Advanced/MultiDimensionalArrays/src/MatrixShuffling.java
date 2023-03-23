import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int rowsMax = dimensions[0];
        int colsMax = dimensions[1];
        String[][] array = new String[rowsMax][colsMax];

        for (int i = 0; i < rowsMax; i++) {
            String[] thisLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < colsMax; j++) {
                array[i][j] = thisLine[j];
            }
        }

        while (true){
            String[] thisLine = scanner.nextLine().split(" ");
            if(thisLine[0].equals("END")){break;}
            boolean isValid = true;
            if(!thisLine[0].equals("swap") || thisLine.length != 5){isValid = false;
            }else if(Integer.parseInt(thisLine[1]) < 0 || Integer.parseInt(thisLine[1]) >= rowsMax) {isValid = false;
            }else if(Integer.parseInt(thisLine[2]) < 0 || Integer.parseInt(thisLine[2]) >= colsMax) {isValid = false;
            }else if(Integer.parseInt(thisLine[3]) < 0 || Integer.parseInt(thisLine[3]) >= rowsMax) {isValid = false;
            }else if(Integer.parseInt(thisLine[4]) < 0 || Integer.parseInt(thisLine[4]) >= colsMax) {isValid = false;
            }

            if(isValid){
                int row1 = Integer.parseInt(thisLine[1]);
                int col1 = Integer.parseInt(thisLine[2]);
                int row2 = Integer.parseInt(thisLine[3]);
                int col2 = Integer.parseInt(thisLine[4]);
                String tempCell = array[row2][col2];
                array[row2][col2] = array[row1][col1];
                array[row1][col1] = tempCell;
                printArr2D(array);
            }else{
                System.out.println("Invalid input!");
            }

        }

    }

    public static void printArr2D(String[][] array){
        for(int row = 0; row < array.length; row++){
            for (int col = 0; col < array[0].length; col++) {
                System.out.printf("%s ", array[row][col]);
            }
            System.out.println();
        }
    }
}
