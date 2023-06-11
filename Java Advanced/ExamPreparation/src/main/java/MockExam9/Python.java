package MockExam9;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] moves = scanner.nextLine().split(",\\s+");
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;
        int pythonLength = 1;
        int foodLeft = 0;

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c*2);
                if(ch == 'f') {
                    foodLeft++;

                } else if (ch == 's') {
                    row = r;
                    col = c;
                }

                field[r][c] = ch;
            }
        }

        // iterating moves
        boolean isEnemyEncountered = false;
        int nextRow = row;
        int nextCol = col;
        String move;
        for (int i = 0; i < moves.length; i++) {
            // updating coordinates
            row = nextRow;
            col = nextCol;
            move = moves[i];

            // updating next coordinates
            switch (move){
                case "up": nextRow--;
                if(nextRow < 0){
                    nextRow = (fieldSize - 1);
                }
                    break;
                case "down": nextRow++;
                if(nextRow >= fieldSize){
                    nextRow = 0;
                }
                    break;
                case "left": nextCol--;
                if(nextCol < 0){
                    nextCol = (fieldSize - 1);
                }
                    break;
                case "right":nextCol++;
                if(nextCol >= fieldSize){
                    nextCol = 0;
                }
                    break;
            }

            // performing move
            char nextCell = field[nextRow][nextCol];
            if(nextCell == 'e'){
                isEnemyEncountered = true;
                break;

            } else if (nextCell == 'f') {
                pythonLength++;
                foodLeft--;
                field[nextRow][nextCol] = '*';
            }
        }

        // printing output
        if(isEnemyEncountered){
            System.out.println("You lose! Killed by an enemy!");

        } else if (foodLeft > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodLeft);
        }else{
            System.out.printf("You win! Final python length is %d", pythonLength);
        }
    }
}
