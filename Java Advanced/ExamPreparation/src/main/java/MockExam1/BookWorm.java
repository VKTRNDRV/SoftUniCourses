package MockExam1;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resultString = scanner.nextLine();
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;

        //filling up field and getting start coordinates
        for (int i = 0; i < fieldSize; i++) {
            String rowLine = scanner.nextLine();
            for (int j = 0; j < fieldSize; j++) {
                char ch = rowLine.charAt(j);
                if(ch == 'P'){
                    row = i;
                    col = j;
                }
                field[i][j] = ch;
            }
        }

        //iterating until end
        while (true){
            String command = scanner.nextLine();
            if(command.equals("end")){break;}
            int rowNext = row;
            int colNext = col;
            boolean isMoveValid = false;

            //updating next coordinates
            switch (command){
                case "up":
                    rowNext--;
                    break;

                case "down":
                    rowNext++;
                    break;

                case "left":
                    colNext--;
                    break;

                case "right":
                    colNext++;
                    break;
            }

            //checking if next cell is within bounds
            if(isCellInField(fieldSize, rowNext, colNext)){

                //updating string, old cell, new cell, coordinates
                char ch = field[rowNext][colNext];
                field[row][col] = '-';
                field[rowNext][colNext] = 'P';
                if(ch != '-'){
                    resultString = resultString.concat(String.valueOf(ch));
                }
                row = rowNext;
                col = colNext;

            }else{
                //updating string
                resultString = resultString.substring(0, resultString.length() - 1);
            }
        }

        //printing result string and field
        System.out.println(resultString);
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.print(field[rowPrint][colPrint]);
            }
            System.out.println();
        }

    }

    public static boolean isCellInField(int fieldSize, int row, int col){
        if(row >= 0 && row < fieldSize){
            return col >= 0 && col < fieldSize;
        }
        return false;
    }
}
