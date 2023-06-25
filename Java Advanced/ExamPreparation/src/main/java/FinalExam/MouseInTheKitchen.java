package FinalExam;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rowsLength = dimensions[0];
        int colsLength = dimensions[1];
        char[][] field = new char[rowsLength][colsLength];
        int playerRow = 0;
        int playerCol = 0;
        int cheeseLeft = 0;

        // filling field
        for (int r = 0; r < rowsLength; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < colsLength; c++) {
                char ch = rowLine.charAt(c);
                if(ch == 'C'){
                    cheeseLeft++;
                }else if(ch == 'M'){
                    playerRow = r;
                    playerCol = c;

                    // replacing player start cell
                    ch = '*';
                }
                field[r][c] = ch;
            }
        }

        // iterating until danger or break
        String move;
        boolean isOutOfField = false;
        boolean isTrapped = false;
        while (true){
            // read next move
            move = scanner.nextLine();
            if(move.equals("danger")){break;}

            // updating coordinates
            if (move.equals("up")) {
                if(playerRow <= 0){
                    isOutOfField = true;
                    break;
                }
                playerRow--;
            } else if (move.equals("down")) {
                if(playerRow >= rowsLength - 1){
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
                if(playerCol >= colsLength - 1){
                    isOutOfField = true;
                    break;
                }
                playerCol++;
            }

            // perform move as per next cell
            char nextCell = field[playerRow][playerCol];
            if(nextCell == '@'){
                // return coordinates and skip move
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

            }else if (nextCell == 'T'){
                isTrapped = true;
                break;

            } else if (nextCell == 'C') {
                cheeseLeft--;
                if(cheeseLeft == 0){
                    field[playerRow][playerCol] = '*';
                    break;
                }
            }

            // update cell
            field[playerRow][playerCol] = '*';
        }

        // print output
        field[playerRow][playerCol] = 'M';
        if(isOutOfField){
            System.out.println("No more cheese for tonight!");
        } else if (isTrapped) {
            System.out.println("Mouse is trapped!");
        } else if (cheeseLeft == 0) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        }else {
            System.out.println("Mouse will come back later!");
        }
        for (int rowPrint = 0; rowPrint < rowsLength; rowPrint++) {
            for (int colPrint = 0; colPrint < colsLength; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }
}
