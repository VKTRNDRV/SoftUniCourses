package MockExam11;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if (ch == 'M') {
                    row = r;
                    col = c;
                }
                field[r][c] = ch;
            }
        }

        int cheeseEaten = 0;
        boolean isMouseOutOfBounds = false;
        field[row][col] = '-';

        // iterating moves
        String move = scanner.nextLine();
        int nextRow = row;
        int nextCol = col;
        while (true){
            if(move.equals("end")){break;}

            // updating next coordinates
            switch (move){
                case "up": nextRow--;
                    if(nextRow < 0){isMouseOutOfBounds = true;}
                    break;
                case "down": nextRow++;
                    if(nextRow >= fieldSize){isMouseOutOfBounds = true;}
                    break;
                case "left": nextCol--;
                    if(nextCol < 0){isMouseOutOfBounds = true;}
                    break;
                case "right":nextCol++;
                    if(nextCol >= fieldSize){isMouseOutOfBounds = true;}
                    break;
            }

            if(isMouseOutOfBounds){break;}

            // performing move
            char nextCell = field[nextRow][nextCol];
            switch (nextCell){
                case 'c':
                    cheeseEaten++;
                    break;

                case 'B':
                    field[nextRow][nextCol] = '-';
                    continue;
            }

            // reading next move and updating coors and field
            move = scanner.nextLine();
            row = nextRow;
            col = nextCol;
            field[row][col] = '-';
        }

        // printing output
        if(isMouseOutOfBounds){
            System.out.println("Where is the mouse?");
        }else{
            field[row][col] = 'M';
        }

        if(cheeseEaten >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeseEaten);

        }else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n",
                    5 - cheeseEaten);
        }

        // printing field
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }

    }
}
