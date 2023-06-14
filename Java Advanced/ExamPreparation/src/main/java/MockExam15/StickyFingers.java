package MockExam15;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int playerRow = 0;
        int playerCol = 0;
        int totalMoneyStolen = 0;
        String[] moves = scanner.nextLine().split(",");

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c*2);
                if (ch == 'D') {
                    playerRow = r;
                    playerCol = c;
                }

                field[r][c] = ch;
            }
        }

        // iterating moves
        String move;
        boolean isCaughtByPolice = false;
        for (int i = 0; i < moves.length; i++) {
            // updating move and field
            move = moves[i];
            field[playerRow][playerCol] = '+';

            // updating coordinates
            if(move.equals("up")){
                if(playerRow > 0) {
                    playerRow--;
                }else{
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (move.equals("down")) {
                if(playerRow < fieldSize - 1){
                    playerRow++;
                }else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (move.equals("left")) {
                if(playerCol > 0) {
                    playerCol--;
                }else{
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (move.equals("right")) {
                if(playerCol < fieldSize - 1){
                    playerCol++;
                }else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            }

            //performing move
            char nextCell = field[playerRow][playerCol];
            if(nextCell == '$'){
                int stolen = playerRow * playerCol;
                totalMoneyStolen += stolen;
                System.out.printf("You successfully stole %d$.\n", stolen);
                
            } else if (nextCell == 'P') {
                isCaughtByPolice = true;
                break;
            }
        }

        // printing output
        if(!isCaughtByPolice){
            field[playerRow][playerCol] = 'D';
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n"
                    , totalMoneyStolen);
        }else {
            field[playerRow][playerCol] = '#';
            System.out.printf("You got caught with %d$, and you are going to jail.\n"
                    , totalMoneyStolen);
        }

        // printing field
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c ", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }
}
