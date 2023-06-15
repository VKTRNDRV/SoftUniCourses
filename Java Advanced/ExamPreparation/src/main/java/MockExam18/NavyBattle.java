package MockExam18;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int playerRow = 0;
        int playerCol = 0;

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if(ch == 'S'){
                    playerRow = r;
                    playerCol = c;

                    // replacing player start position
                    ch = '-';
                }
                field[r][c] = ch;
            }
        }

        // iterating until end of game
        boolean isGameWon;
        int cruisersDowned = 0;
        int minesBlown = 0;
        String move;
        while (true){
            move = scanner.nextLine();

            // updating coordinates - always valid
            if (move.equals("up")) {
                playerRow--;
            } else if (move.equals("down")) {
                playerRow++;
            } else if (move.equals("left")) {
                playerCol--;
            } else if (move.equals("right")) {
                playerCol++;
            }

            // perform move
            char nextCell = field[playerRow][playerCol];
            if(nextCell == '*'){
                minesBlown++;
                field[playerRow][playerCol] = '-';
                if(minesBlown >= 3){
                    isGameWon = false;
                    break;
                }
            } else if (nextCell == 'C') {
                cruisersDowned++;
                field[playerRow][playerCol] = '-';
                if(cruisersDowned >= 3){
                    isGameWon = true;
                    break;
                }
            }
        }

        // print output
        field[playerRow][playerCol] = 'S';
        if(isGameWon){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n"
                    , playerRow, playerCol);
        }
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }
}
