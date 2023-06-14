package MockExam16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int rowLength = scanner.nextInt();
        int colLength = scanner.nextInt();
        scanner.nextLine();
        char[][] field = new char[rowLength][colLength];
        int playerRow = 0;
        int playerCol = 0;
        List<String> pathSteps = new ArrayList<>();

        // filling field
        for (int r = 0; r < rowLength; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < colLength; c++) {
                char ch = rowLine.charAt(c*2);
                if (ch == 'Y') {
                    playerRow = r;
                    playerCol = c;
                }

                field[r][c] = ch;
            }
        }

        // iterate moves until finish
        boolean isTreasureFound = false;
        while (true){
            String move = scanner.nextLine();

            // end game and check for treasure IF finish
            if(move.equals("Finish")){
                if(field[playerRow][playerCol] == 'X'){
                    isTreasureFound = true;
                }
                break;
            }

            // check if out of field and update coors
            boolean isMoveValid = true;
            if(move.equals("up")){
                if(playerRow > 0) {
                    playerRow--;
                }else{
                    isMoveValid = false;
                }
            } else if (move.equals("down")) {
                if(playerRow < rowLength - 1){
                    playerRow++;
                }else {
                    isMoveValid = false;
                }
            } else if (move.equals("left")) {
                if(playerCol > 0) {
                    playerCol--;
                }else{
                    isMoveValid = false;
                }
            } else if (move.equals("right")) {
                if(playerCol < colLength - 1){
                    playerCol++;
                }else {
                    isMoveValid = false;
                }
            }

            // check for tree and update coors
            if(field[playerRow][playerCol] == 'T'){
                switch (move){
                    case "up": playerRow++; break;
                    case "down": playerRow--; break;
                    case "left": playerCol++; break;
                    case "right": playerCol--; break;
                }
                isMoveValid = false;
            }

            // add move to path if valid
            if(isMoveValid){
                pathSteps.add(move);
            }
        }

        // print output
        if(isTreasureFound){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            for (int i = 0; i < pathSteps.size() - 1; i++) {
                System.out.printf("%s, ", pathSteps.get(i));
            }
            System.out.print(pathSteps.get(pathSteps.size() - 1));
        }else {
            System.out.println("The map is fake!");
        }
    }
}
