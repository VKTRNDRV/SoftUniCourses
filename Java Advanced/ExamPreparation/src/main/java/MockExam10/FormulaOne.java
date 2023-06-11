package MockExam10;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;

        // filling field
        for (int r = 0; r < fieldSize; r++) {
            String rowLine = scanner.nextLine();
            for (int c = 0; c < fieldSize; c++) {
                char ch = rowLine.charAt(c);
                if (ch == 'P') {
                    row = r;
                    col = c;
                }
                field[r][c] = ch;
            }
        }

        // iterating moves
        boolean isFinishReached = false;
        field[row][col] = '.';
        int nextRow = row;
        int nextCol = col;
        while (commandsCount > 0 && !isFinishReached){
            String move = scanner.nextLine();

            // updating next coordinates
            switch (move){
                case "up": nextRow = updateRow(row, "up", fieldSize);
                    break;
                case "down": nextRow = updateRow(row, "down", fieldSize);
                    break;
                case "left": nextCol = updateCol(col, "left", fieldSize);
                    break;
                case "right": nextCol = updateCol(col, "right", fieldSize);
                    break;
            }

            // performing move
            char nextCell = field[nextRow][nextCol];
            if(nextCell == 'F'){
                row = nextRow;
                col = nextCol;
                isFinishReached = true;
                continue;

            } else if (nextCell == 'B') {
                switch (move){
                    case "up": nextRow = updateRow(nextRow, "up", fieldSize);
                        break;
                    case "down": nextRow = updateRow(nextRow, "down", fieldSize);
                        break;
                    case "left": nextCol = updateCol(nextCol, "left", fieldSize);
                        break;
                    case "right": nextCol = updateCol(nextCol, "right", fieldSize);
                        break;
                }
                if(field[nextRow][nextCol] == 'F'){
                    row = nextRow;
                    col = nextCol;
                    isFinishReached = true;
                    continue;
                }

            }else if (nextCell == 'T'){
                nextRow = row;
                nextCol = col;
            }

            // updating coordinates
            row = nextRow;
            col = nextCol;

            commandsCount--;
        }

        // putting player on last cell
        field[row][col] = 'P';

        // printing output
        if(isFinishReached){
            System.out.println("Well done, the player won first place!");
        }else{
            System.out.println("Oh no, the player got lost on the track!");
        }

        // printing field
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }

    public static int updateRow(int row, String direction, int fieldSize){
        switch (direction){
            case "up": row--;break;
            case "down": row++;break;
        }

        if(row < 0){
            row = fieldSize - 1;
        }

        if(row >= fieldSize){
            row = 0;
        }

        return row;
    }

    public static int updateCol(int col, String direction, int fieldSize){
        switch (direction){
            case "left": col--;break;
            case "right": col++;break;
        }

        if(col < 0){
            col = fieldSize - 1;
        }

        if(col >= fieldSize){
            col = 0;
        }

        return col;
    }
}
