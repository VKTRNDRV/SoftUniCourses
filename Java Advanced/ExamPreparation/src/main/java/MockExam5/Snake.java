package MockExam5;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // filling field
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;

        boolean containsLair = false;
        int lairRow1 = 0;   int lairRow2 = 0;
        int lairCol1 = 0;   int lairCol2 = 0;

        int foodEatenCount = 0;

        boolean isFirstBurrowFilled = false;
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if(ch == 'S'){
                    row = r;
                    col = c;

                }else if(ch == 'B' && !isFirstBurrowFilled){
                    containsLair = true;
                    lairRow1 = r;
                    lairCol1 = c;
                    isFirstBurrowFilled = true;

                }else if(ch == 'B' && isFirstBurrowFilled){
                    lairRow2 = r;
                    lairCol2 = c;
                }

                field[r][c] = ch;
            }
        }

        // iterating until end
        int rowNext = row;
        int colNext = col;
        boolean isSnakeLost = false;
        String move = scanner.nextLine();
        while (true){

            // rewriting old coors to new coors
            row = rowNext;
            col = colNext;

            // adjusting next coordinates based on move
            switch (move){
                case "up": rowNext--;
                    break;
                case "down": rowNext++;
                    break;
                case "left": colNext--;
                    break;
                case "right":colNext++;
                    break;
            }

            // leaving trail on old cell
            field[row][col] = '.';

            // stop game if next cell is outside field
            if(!areCoordinatesValid(rowNext, colNext, fieldSize)){
                isSnakeLost = true;
                break;
            }

            // read next cell
            char nextCell = field[rowNext][colNext];

            switch (nextCell){
                case '-':
                case '.':
                    break;

                case '*':
                    foodEatenCount++;
                    break;

                case 'B':
                    // leaving trail on entry burrow cell
                    field[rowNext][colNext] = '.';

                    // rewriting new coordinates to exit burrow
                    if(rowNext == lairRow1 && colNext == lairCol1){
                        rowNext = lairRow2;
                        colNext = lairCol2;
                    }else{
                        rowNext = lairRow1;
                        colNext = lairCol1;
                    }
                    break;
            }

            if(foodEatenCount >= 10){
                field[rowNext][colNext] = 'S';
                break;
            }

            move = scanner.nextLine();
        }

        // printing output
        if(foodEatenCount >= 10){
            System.out.println("You won! You fed the snake.");
        }else{
            System.out.println("Game over!");
        }

        System.out.printf("Food eaten: %d\n", foodEatenCount);

        // printing matrix
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }

    public static boolean areCoordinatesValid(int row, int col, int fieldSize){
        return (row >= 0 && row < fieldSize &&
                col >= 0 && col < fieldSize);
    }
}
