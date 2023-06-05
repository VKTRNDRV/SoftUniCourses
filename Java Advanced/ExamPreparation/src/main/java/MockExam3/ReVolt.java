package MockExam3;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int movesCount = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];

        // [0]:row, [1]:col
        int[] coordinates = {0, 0};

        // reading cells
        for (int i = 0; i < fieldSize; i++) {
            String rowLine = scanner.nextLine();
            for (int j = 0; j < fieldSize; j++) {
                char ch = rowLine.charAt(j);
                if(ch == 'f'){coordinates[0] = i; coordinates[1] = j;}

                field[i][j] = ch;
            }
        }


        // iterating until game is won or over
        boolean isGameWon = false;
        while (!isGameWon && movesCount > 0) {
            String direction = scanner.nextLine();

            // rewriting old cell
            field[coordinates[0]][coordinates[1]] = '-';

            // adjusting next coordinates
            coordinates = updateCoordinates(coordinates, direction, fieldSize);

            // performing move based on new cell
            char nextCell = field[coordinates[0]][coordinates[1]];
            switch (nextCell) {
                case '-': break;
                case 'F': isGameWon = true;break;

                // perform a duplicate of the last move
                case 'B': coordinates = updateCoordinates(coordinates, direction, fieldSize);break;

                // perform the opposite (to the last move) direction move
                case 'T':
                    switch (direction) {
                        case "up": coordinates = updateCoordinates(coordinates, "down", fieldSize);break;
                        case "down": coordinates = updateCoordinates(coordinates, "up", fieldSize);break;
                        case "left": coordinates = updateCoordinates(coordinates, "right", fieldSize);break;
                        case "right": coordinates = updateCoordinates(coordinates, "left", fieldSize);break;
                    }
                    break;
            }

            // rewriting new cell contents
            field[coordinates[0]][coordinates[1]] = 'f';

            movesCount--;
        }

        // printing output
        if(isGameWon){System.out.println("Player won!");
        }else{System.out.println("Player lost!");}

        // printing field
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }

    public static int[] updateCoordinates(int[] coordinates, String direction, int fieldSize){


        switch (direction){
            case "up": --coordinates[0];break;
            case "down": ++coordinates[0];break;
            case "left": --coordinates[1];break;
            case "right": ++coordinates[1];break;
        }

        if (coordinates[0] < 0){coordinates[0] = fieldSize - 1;}
        if (coordinates[0] >= fieldSize){coordinates[0] = 0;}

        if (coordinates[1] < 0){coordinates[1] = fieldSize - 1;}
        if (coordinates[1] >= fieldSize){coordinates[1] = 0;}

        return coordinates;
    }
}
