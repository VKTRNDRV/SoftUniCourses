package MockExam14;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int playerRow = 0;
        int playerCol = 0;
        int coinsSpent = 0;
        int firstMirrorRow = 0;
        int firstMirrorCol = 0;
        int secondMirrorRow = 0;
        int secondMirrorCol = 0;

        // filling field
        boolean isFirstMirrorFilled = false;
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if (ch == 'A') {
                    playerRow = r;
                    playerCol = c;

                } else if(ch == 'M' && !isFirstMirrorFilled){
                    firstMirrorRow = r;
                    firstMirrorCol = c;
                    isFirstMirrorFilled = true;

                } else if (ch == 'M') {
                    secondMirrorRow = r;
                    secondMirrorCol = c;
                }

                field[r][c] = ch;
            }
        }

        // iterating until end
        String move = scanner.nextLine();
        char nextCell;
        boolean isOutOfBounds = false;
        while (true){
            // filling last cell
            field[playerRow][playerCol] = '-';

            // updating coordinates
            if(move.equals("up")){
                playerRow--;
            } else if (move.equals("down")) {
                playerRow++;
            } else if (move.equals("left")) {
                playerCol--;
            } else if (move.equals("right")) {
                playerCol++;
            }

            // break if out of bounds
            if(playerRow < 0 || playerRow >= fieldSize || playerCol < 0 || playerCol >= fieldSize){
                isOutOfBounds = true;
                break;
            }

            // perform move as per new cell
            nextCell = field[playerRow][playerCol];
            if(Character.isDigit(nextCell)){
                coinsSpent += Integer.parseInt(String.valueOf(nextCell));
                if(coinsSpent >= 65){
                    break;
                }

            } else if (nextCell == 'M') {
                field[playerRow][playerCol] = '-';
                if(playerRow == firstMirrorRow && playerCol == firstMirrorCol){
                    playerRow = secondMirrorRow;
                    playerCol = secondMirrorCol;

                } else if (playerRow == secondMirrorRow && playerCol == secondMirrorCol) {
                    playerRow = firstMirrorRow;
                    playerCol = firstMirrorCol;
                }
            }

            // reading next move
            move = scanner.nextLine();
        }

        // printing output
        if(!isOutOfBounds){
            field[playerRow][playerCol] = 'A';
            System.out.println("Very nice swords, I will come back for more!");
        }else {
            System.out.println("I do not need more swords!");
        }
        System.out.printf("The king paid %d gold coins.\n", coinsSpent);

        // printing matrix
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }
}
