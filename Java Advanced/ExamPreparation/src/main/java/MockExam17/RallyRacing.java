package MockExam17;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        String carNumber = scanner.nextLine();
        int playerRow = 0;
        int playerCol = 0;
        int totalKilometersTravelled = 0;
        int tunnelRow1 = 0;
        int tunnelCol1 = 0;
        int tunnelRow2 = 0;
        int tunnelCol2 = 0;

        // filling field
        boolean isFirstTunnelRead = false;
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c*2);
                if(ch == 'T' && !isFirstTunnelRead){
                    tunnelRow1 = r;
                    tunnelCol1 = c;
                    isFirstTunnelRead = true;
                } else if (ch == 'T') {
                    tunnelRow2 = r;
                    tunnelCol2 = c;
                }
                field[r][c] = ch;
            }
        }

        // iterate moves
        boolean isFinishReached = false;
        while (true){
            String move = scanner.nextLine();

            // updating coordinates - always valid
            if (move.equals("up")) {
                playerRow--;
            } else if (move.equals("down")) {
                playerRow++;
            } else if (move.equals("left")) {
                playerCol--;
            } else if (move.equals("right")) {
                playerCol++;
            } else if (move.equals("End")) {
                break;
            }

            // add km
            totalKilometersTravelled += 10;

            // perform move
            char nextCell = field[playerRow][playerCol];
            if(nextCell == 'F'){
                isFinishReached = true;
                break;
            } else if (nextCell == 'T') {
                if(playerRow == tunnelRow1 && playerCol == tunnelCol1){
                    playerRow = tunnelRow2;
                    playerCol = tunnelCol2;
                }else if (playerRow == tunnelRow2 && playerCol == tunnelCol2){
                    playerRow = tunnelRow1;
                    playerCol = tunnelCol1;
                }

                // add tunnel km and remove tunnels
                totalKilometersTravelled += 20;
                field[tunnelRow1][tunnelCol1] = '.';
                field[tunnelRow2][tunnelCol2] = '.';
            }
        }

        // add car on last cell
        field[playerRow][playerCol] = 'C';

        //print output
        if(isFinishReached){
            System.out.printf("Racing car %s finished the stage!\n", carNumber);
        }else {
            System.out.printf("Racing car %s DNF.\n", carNumber);
        }
        System.out.printf("Distance covered %d km.\n", totalKilometersTravelled);
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }
}
