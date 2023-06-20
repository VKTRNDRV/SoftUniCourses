package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read dimensions and create matrix
        int[] dimensions = parseCoordinates(scanner.nextLine());
        int rowLength = dimensions[0];
        int colLength = dimensions[1];
        int[][] matrix = new int[rowLength][colLength];

        // fill matrix
        int value = 0;
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                matrix[r][c] = value++;
            }
        }

        // iterate until let the...
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you"))
        {
            // read coordinates
            int[] playerCoordinates = parseCoordinates(command);
            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];
            command = scanner.nextLine();
            int[] evilCoordinates = parseCoordinates(command);
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            // set all evil cells to 0
            while (evilRow >= 0 && evilCol >= 0)
            {
                if (areCoordinatesValid(evilRow, evilCol, rowLength, colLength))
                {
                    matrix[evilRow] [evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            // add player diagonal values to sum
            while (playerRow >= 0 && playerCol < matrix[1].length)
            {
                if (areCoordinatesValid(playerRow, playerCol, rowLength, colLength))
                {
                    sum += matrix[playerRow][playerCol];
                }

                playerCol++;
                playerRow--;
            }


            // read next command
            command = scanner.nextLine();
        }

        // print output
        System.out.println(sum);
    }

    public static int[] parseCoordinates(String input){
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean areCoordinatesValid(int row, int col, int rowLength, int colLength){
        return row >= 0 && row < rowLength &&
                col >= 0 && col < colLength;
    }

    public static int getCellValue(int row, int col, int rowLength){
        return (row * rowLength) + col;
    }
}
