package MockExam7;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] moves = scanner.nextLine().split(",");

        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;    int col = 0;
        int bombsCount = 0;

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c*2);
                if(ch == 's'){
                    row = r;    col = c;
                }

                if(ch == 'B'){
                    bombsCount++;
                }

                field[r][c] = ch;
            }
        }

        // iterating for every move
        int nextRow = row;
        int nextCol = col;
        boolean isEndReached = false;
        String move;
        for (int i = 0; i < moves.length; i++) {

            // reading move
            move = moves[i];

            // adjusting next coordinates based on move
            switch (move){
                case "up":
                if(row > 0){
                    nextRow--;
                }
                    break;
                case "down":
                if(row < field.length - 1){
                    nextRow++;
                }
                    break;
                case "left":
                if(col > 0){
                    nextCol--;
                }
                    break;
                case "right":
                if(col < field.length - 1){
                    nextCol++;
                }
                    break;
            }

            // performing move based on next cell
            char nextCell = field[nextRow][nextCol];
            switch (nextCell){
                case 's':
                case '+':
                    break;
                case 'e':
                    isEndReached = true;
                    break;
                case 'B':
                    bombsCount--;
                    field[nextRow][nextCol] = '+';
                    System.out.println("You found a bomb!");
                    break;
            }

            // updating coordinates
            row = nextRow;
            col = nextCol;

            //ending game if e reached or no more bombs
            if(isEndReached){
                break;
            }
        }

        if(isEndReached && bombsCount > 0){
            System.out.printf("END! %d bombs left on the field\n", bombsCount);

        }else if(bombsCount <= 0){
            System.out.print("Congratulations! You found all bombs!");
        }else{
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsCount, row, col);
        }
    }
}
