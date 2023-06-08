package MockExam6;

import java.nio.file.Path;
import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // filling field
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;

        boolean containsPillars = false;
        int pillarRow1 = 0;   int pillarRow2 = 0;
        int pillarCol1 = 0;   int pillarCol2 = 0;

        int moneyCollected = 0;

        boolean isFirstPillarFilled = false;
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if(ch == 'S'){
                    row = r;
                    col = c;

                    // checking for pillars
                }else if(ch == 'O' && !isFirstPillarFilled){
                    containsPillars = true;
                    pillarRow1 = r;
                    pillarCol1 = c;
                    isFirstPillarFilled = true;

                }else if(ch == 'O' && isFirstPillarFilled){
                    pillarRow2 = r;
                    pillarCol2 = c;
                }

                field[r][c] = ch;
            }
        }

        // iterating until end
        boolean isOutsideField = false;
        int nextRow = row;
        int nextCol = col;
        String move = scanner.nextLine();
        while (true){

            // adjusting next coordinates based on move
            switch (move){
                case "up": nextRow--;
                    break;
                case "down": nextRow++;
                    break;
                case "left": nextCol--;
                    break;
                case "right":nextCol++;
                    break;
            }

            // rewriting old cell
            field[row][col] = '-';

            // stop game if next cell is outside field
            if(!areCoordinatesValid(nextRow, nextCol, fieldSize)){
                isOutsideField = true;
                break;
            }

            // read next cell
            char nextCell = field[nextRow][nextCol];

            // perform move
            if(Character.isDigit(nextCell)){
                moneyCollected += Integer.parseInt(String.valueOf(nextCell));

            }else{
                switch (nextCell){
                    case '-':
                        break;
                    case 'O':
                        // rewriting entry pillar cell
                        field[nextRow][nextCol] = '-';

                        // rewriting new coordinates to exit pillar
                        if(nextRow == pillarRow1 && nextCol == pillarCol1){
                            nextRow = pillarRow2;
                            nextCol = pillarCol2;
                        }else{
                            nextRow = pillarRow1;
                            nextCol = pillarCol1;
                        }
                        break;
                }
            }

            // updating current coors
            row = nextRow;
            col = nextCol;

            // end game if cash is enough
            if(moneyCollected >= 50){
                field[row][col] = 'S';
                break;
            }

            //read next move
            move = scanner.nextLine();
        }

        //printing output
        if(isOutsideField){
            System.out.println("Bad news, you are out of the bakery.");
        }else{
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d\n", moneyCollected);

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
