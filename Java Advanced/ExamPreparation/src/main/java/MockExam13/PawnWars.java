package MockExam13;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[8][8];
        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;

        // read field
        for (int r = 7; r > 0; r--) {
            String row = scanner.nextLine();
            for (int c = 0; c < 8; c++){
                char ch = row.charAt(c);
                if(ch == 'b'){
                    blackRow = r;
                    blackCol = c;

                } else if (ch == 'w') {
                    whiteRow = r;
                    whiteCol = c;
                }

                field[r][c] = ch;
            }
        }

        // iterate until end
        while(true){
            // check if white captures
            if(whiteRow + 1 == blackRow
                    && (whiteCol - 1 == blackCol || whiteCol + 1 == blackCol)){
                System.out.printf("Game over! White capture on %c%d."
                        , blackCol + 97, blackRow + 1);
                break;
            }

            // move white
            whiteRow++;

            // check if white promotes
            if(whiteRow == 7){
                System.out.printf("Game over! White pawn is promoted to a queen at %c%d."
                        , whiteCol + 97, whiteRow + 1);
                break;
            }

            // check if black captures
            if(blackRow - 1 == whiteRow
                    && (blackCol - 1 == whiteCol || blackCol + 1 == whiteCol)){
                System.out.printf("Game over! Black capture on %c%d."
                        , whiteCol + 97, whiteRow + 1);
                break;
            }

            // move black
            blackRow--;

            // check if black promotes
            if(blackRow == 0){
                System.out.printf("Game over! Black pawn is promoted to a queen at %c%d."
                        , blackCol + 97, blackRow + 1);
                break;
            }
        }
    }
}
