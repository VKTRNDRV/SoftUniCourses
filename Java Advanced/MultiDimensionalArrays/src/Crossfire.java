import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        int rowMax = dimensions[0];
        int colMax = dimensions[1];
        int[][] array = createIncrementingArray(rowMax, colMax);

        while (true){
            String[] line = scanner.nextLine().split("\\s+");
            if(line[0].equals("Nuke")){break;}

            int centrePointRow = Integer.parseInt(line[0]);
            int centrePointCol = Integer.parseInt(line[1]);
            int radius = Integer.parseInt(line[2]);



            //delete horizontal
            for (int i = centrePointCol - radius; i <= centrePointCol + radius; i++) {
                int thisPointCol = i;
                int thisPointRow = centrePointRow;
                if(isInMatrix(thisPointRow, thisPointCol, array)){
                    array[thisPointRow][thisPointCol] = 0;
                }
            }

            //delete vertical
            for (int i = centrePointRow - radius; i <= centrePointRow + radius; i++) {
                int thisPointCol = centrePointCol;
                int thisPointRow = i;
                if(isInMatrix(thisPointRow, thisPointCol, array)){
                    array[thisPointRow][thisPointCol] = 0;
                }
            }

            moveCells(array);

            deleteEmptyRows(array);

//            printArray(array);
//            System.out.println();
//            System.out.println();
        }

        printArray(array);
    }

    public static int[][] createIncrementingArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int count = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = count;
                count++;
            }
        }

        return array;
    }

    public static boolean isInMatrix(int row, int col, int[][] array){
        if(row >= 0 && row < array.length &&
        col >= 0 && col < array[0].length){
            return true;
        }

        return false;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    System.out.print(array[i][j] + " ");
                }else{
                    break;
                }
            }
            System.out.println();
        }
    }

    public static void moveCells(int[][] array){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length - 1; col++){
                if(array[row][col] == 0){

                    //check all cells until the end of the row for any non-zero values
                    for (int thisCol = col; thisCol < array[0].length; thisCol++) {

                        //exchange them if found and break
                        if(array[row][thisCol] != 0){
                            array[row][col] = array[row][thisCol];
                            array[row][thisCol] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void deleteEmptyRows(int[][] array) {
        int targetRow = 0; // Track the position to move non-empty rows
        for (int row = 0; row < array.length; row++) {
            boolean isEmpty = true;
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] != 0) {
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                if (targetRow != row) {
                    System.arraycopy(array[row], 0, array[targetRow], 0, array[0].length);
                }
                targetRow++;
            }
        }
        // Fill the remaining rows with zeroes
        for (int row = targetRow; row < array.length; row++) {
            Arrays.fill(array[row], 0);
        }
    }
}
