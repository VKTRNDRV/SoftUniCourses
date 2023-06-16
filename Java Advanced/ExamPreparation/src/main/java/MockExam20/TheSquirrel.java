package MockExam20;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] moves = scanner.nextLine().split(",\\s+");
        char[][] field = new char[fieldSize][fieldSize];
        int playerRow = 0;
        int playerCol = 0;
        int hazelnutsCollected = 0;
        boolean isOutOfField = false;
        boolean isCaughtInTrap = false;

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if(ch == 's'){
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
        for (int i = 0; i < moves.length; i++) {
            move = moves[i];

            // updating coordinates
            if (move.equals("up")) {
                if(playerRow <= 0){
                    isOutOfField = true;
                    break;
                }
                playerRow--;
            } else if (move.equals("down")) {
                if(playerRow >= fieldSize - 1){
                    isOutOfField = true;
                    break;
                }
                playerRow++;
            } else if (move.equals("left")) {
                if(playerCol <= 0){
                    isOutOfField = true;
                    break;
                }
                playerCol--;
            } else if (move.equals("right")) {
                if(playerCol >= fieldSize - 1){
                    isOutOfField = true;
                    break;
                }
                playerCol++;
            }

            // perform move as per next cell
            char nextCell = field[playerRow][playerCol];
            if(nextCell == 't'){
                isCaughtInTrap = true;
                break;
                
            } else if (nextCell == 'h') {
                hazelnutsCollected++;
                field[playerRow][playerCol] = '*';
                if(hazelnutsCollected == 3){
                    break;
                }
            }
        }

        // print output
        if(isOutOfField){
            System.out.println("The squirrel is out of the field.");
        } else if (isCaughtInTrap) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        } else if (hazelnutsCollected < 3) {
            System.out.println("There are more hazelnuts to collect.");
        }else {
            System.out.println("Good job! You have collected all hazelnuts!");
        }
        System.out.printf("Hazelnuts collected: %d", hazelnutsCollected);
    }
}
