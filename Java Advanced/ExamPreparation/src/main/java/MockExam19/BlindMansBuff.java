package MockExam19;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsCount = scanner.nextInt();
        int colsCount = scanner.nextInt();
        scanner.nextLine();
        char[][] field = new char[rowsCount][colsCount];
        int playerRow = 0;
        int playerCol = 0;
        int movesCount = 0;
        int playersCaught = 0;

        // filling field
        for (int r = 0; r < rowsCount; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < colsCount; c++) {
                char ch = rowLine.charAt(c*2);
                if(ch == 'B'){
                    playerRow = r;
                    playerCol = c;

                    // replacing player start position
                    ch = '-';
                }
                field[r][c] = ch;
            }
        }

        // iterate moves
        String move;
        while (true){
            move = scanner.nextLine();
            if(move.equals("Finish")){
                break;
            }

            // updating coordinates or cancel move
            if (move.equals("up")) {
                if(playerRow <= 0){
                    continue;
                }
                playerRow--;
            } else if (move.equals("down")) {
                if(playerRow >= rowsCount - 1){
                    continue;
                }
                playerRow++;
            } else if (move.equals("left")) {
                if(playerCol <= 0){
                    continue;
                }
                playerCol--;
            } else if (move.equals("right")) {
                if(playerCol >= colsCount - 1){
                    continue;
                }
                playerCol++;
            }

            // perform or cancel move as per next cell
            char nextCell = field[playerRow][playerCol];
            if(nextCell == 'O'){
                // reverse move
                if (move.equals("up")) {
                    playerRow++;
                } else if (move.equals("down")) {
                    playerRow--;
                } else if (move.equals("left")) {
                    playerCol++;
                } else if (move.equals("right")) {
                    playerCol--;
                }
                continue;

            } else if (nextCell == 'P') {
                playersCaught++;
                field[playerRow][playerCol] = '-';

                // break game if all oponents caught
                if(playersCaught >= 3){
                    movesCount++;
                    break;
                }
            }

            // increment movesCount IF move performed
            movesCount++;
        }

        // printing output
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", playersCaught, movesCount);
    }
}
