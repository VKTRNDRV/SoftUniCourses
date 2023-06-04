package MockExam2;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presentsCount = Integer.parseInt(scanner.nextLine());
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;
        int niceKidsLeftCount = 0;
        int givenPresentsCount = 0;

        //reading cells
        for (int i = 0; i < fieldSize; i++) {
            String rowLine = scanner.nextLine();
            for (int j = 0; j < fieldSize; j++) {
                char ch = rowLine.charAt(j*2);
                if(ch == 'S'){row = i; col = j;}
                if(ch == 'V'){niceKidsLeftCount++;}

                field[i][j] = ch;
            }
        }

        //iterating until no presents or end
        while (presentsCount > 0){
            String command = scanner.nextLine();
            if(command.equals("Christmas morning")){break;}
            int rowNext = row;
            int colNext = col;

            //updating next coordinates
            switch (command){
                case "up": rowNext--; break;
                case "down": rowNext++; break;
                case "left": colNext--; break;
                case "right": colNext++; break;
            }

            //moving santa (updating row and col) if move is valid
            if(isCellInField(fieldSize, rowNext, colNext)) {
                field[row][col] = '-';
                row = rowNext;
                col = colNext;
            }

            //performing action on current cell
            switch (field[row][col]){
                case '-':
                case 'X':
                    break;

                case 'V':
                    niceKidsLeftCount--;
                    givenPresentsCount++;
                    presentsCount--;
                    break;

                case 'C':
                    char leftChar = field[row][col - 1];
                    char rightChar = field[row][col + 1];
                    char upChar = field[row - 1][col];
                    char downChar = field[row + 1][col];

                    //repeating for every adjacent cell
                    //left cell
                    if(leftChar == 'X'){
                        presentsCount--;
                        givenPresentsCount++;
                    }else if(leftChar == 'V'){
                        presentsCount--;
                        givenPresentsCount++;
                        niceKidsLeftCount--;
                    }
                    field[row][col - 1] = '-';

                    //right cell
                    if(rightChar == 'X'){
                        presentsCount--;
                        givenPresentsCount++;
                    }else if(rightChar == 'V'){
                        presentsCount--;
                        givenPresentsCount++;
                        niceKidsLeftCount--;
                    }
                    field[row][col + 1] = '-';

                    //up cell
                    if(upChar == 'X'){
                        presentsCount--;
                        givenPresentsCount++;
                    }else if(upChar == 'V'){
                        presentsCount--;
                        givenPresentsCount++;
                        niceKidsLeftCount--;
                    }
                    field[row - 1][col] = '-';

                    //down cell
                    if(downChar == 'X'){
                        presentsCount--;
                        givenPresentsCount++;
                    }else if(downChar == 'V'){
                        presentsCount--;
                        givenPresentsCount++;
                        niceKidsLeftCount--;
                    }
                    field[row + 1][col] = '-';
                    break;
            }

            //updating current cell
            field[row][col] = '-';
        }

        //putting Santa on his last visited cell
        field[row][col] = 'S';

        //printing output
        if(presentsCount <= 0){System.out.println("Santa ran out of presents!");}
        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c ", field[rowPrint][colPrint]);
            }
            System.out.println();
        }

        if(niceKidsLeftCount <= 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.", givenPresentsCount);
        }else{
            System.out.printf("No presents for %d nice kid/s.", niceKidsLeftCount);
        }
    }

    public static boolean isCellInField(int fieldSize, int row, int col){
        if(row >= 0 && row < fieldSize){
            return col >= 0 && col < fieldSize;
        }
        return false;
    }
}
