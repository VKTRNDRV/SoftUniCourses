package MockExam4;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading and filling field
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][fieldSize];
        int row = 0;
        int col = 0;
        int pollinatedFlowersCount = 0;
        boolean isBeeLost= false;
        for (int i = 0; i < fieldSize; i++) {
            String rowLine = scanner.nextLine();
            for (int j = 0; j < fieldSize; j++) {
                char ch = rowLine.charAt(j);
                if(ch == 'B'){
                    row = i;
                    col = j;
                }

                field[i][j] = ch;
            }
        }

        String move = scanner.nextLine();
        int rowNext = row;
        int colNext = col;

        // making moves until game is over
        while (!isBeeLost){
            if(move.equals("End")){break;}

            // rewriting old cell
            field[row][col] = '.';

            // adjusting next coordinates based on move
            switch (move){
                case "up": rowNext--;
                    break;
                case "down": rowNext++;
                    break;
                case "left": colNext--;
                    break;
                case "right":colNext++;
                    break;
            }

            // if move is invalid - end game
            if(!areCoordinatesValid(rowNext, colNext, fieldSize)){
                isBeeLost = true;
                break;
            }

            // checking next cell
            char nextCell = field[rowNext][colNext];

            // if next cell is bonus rewrite bonus cell, update coordinates and nextChar
            if(nextCell == 'O'){
                field[rowNext][colNext] = '.';

                switch (move){
                    case "up": rowNext--;
                        break;
                    case "down": rowNext++;
                        break;
                    case "left": colNext--;
                        break;
                    case "right":colNext++;
                        break;
                }

                nextCell = field[rowNext][colNext];
            }

            // perform move
            switch (nextCell){
                case '.':
                    break;
                case 'f':
                    pollinatedFlowersCount++;
                    break;
            }

            // putting bee in new cell
            field[rowNext][colNext] = 'B';

            // updating current coordinates to one from last move
            row = rowNext;
            col = colNext;

            move = scanner.nextLine();
        }

        // if bee is not lot, putting bee in last cell
        if(isBeeLost){
            System.out.println("The bee got lost!");
        }

        if(pollinatedFlowersCount >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowersCount);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowersCount);
        }

        for (int rowPrint = 0; rowPrint < fieldSize; rowPrint++) {
            for (int colPrint = 0; colPrint < fieldSize; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }

    public static boolean areCoordinatesValid(int row, int col, int fieldSize){
        return (row >= 0 && row < fieldSize &&
                col >= 0 && col < fieldSize);
    }
}
