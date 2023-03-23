import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(inputs[0]);
        String key = inputs[1];
        int[][] array = new int[size][size];
        switch (key){
            case "A":
                array = fillArrA(size);
                break;

            case "B":
                array = fillArrB(size);
                break;
        }

        printArr2D(array);
    }

    public static int[][] fillArrA(int size){
        int[][] array = new int[size][size];
        int cellCount = 1;
        for (int col = 0; col < size; col++) {
            for(int row = 0; row < size; row++){
                array[row][col] = cellCount;
                cellCount++;
            }
        }

        return array;
    }

    public static int[][] fillArrB(int size){
        int[][] array = new int[size][size];
        int cellCount = 1;
        for (int col = 0; col < size; col++) {
            if(col % 2 == 0){
                for(int row = 0; row < size; row++){
                    array[row][col] = cellCount;
                    cellCount++;
                }
            }else{
                for(int row = (size-1); row >= 0; row--){
                    array[row][col] = cellCount;
                    cellCount++;
                }
            }
        }

        return array;
    }

    public static void printArr2D(int[][] array){
        for(int row = 0; row < array.length; row++){
            for (int col = 0; col < array[0].length; col++) {
                System.out.printf("%d ", array[row][col]);
            }
            System.out.println();
        }
    }
}
