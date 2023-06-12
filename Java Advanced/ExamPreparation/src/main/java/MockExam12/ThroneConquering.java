package MockExam12;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[rows][rows];

        // filling field
        for (int row = 0; row < rows; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }

        // reading player position
        int parisRow = 0;
        int parisCol = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        // iterating moves
        boolean isGameWon = false;
        while (true){
            String command = scanner.nextLine();
            // updating coors, field, move
            String direction = command.split(" ")[0];
            int enemyRow = Integer.parseInt(command.split(" ")[1]);
            int enemyCol = Integer.parseInt(command.split(" ")[2]);

            field[parisRow][parisCol] = '-';
            field[enemyRow][enemyCol] = 'S';
            // updating next coordinates
            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < field.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if(parisCol + 1 < field.length) {
                        parisCol++;
                    }

                    break;
            }
            // after move
            // decrease energy
            energy--;
            // end game if no energy
            if(energy <= 0){
                break;
            }

            // if spartan encountered
            char nextCell = field[parisRow][parisCol];
            if (nextCell == 'S') {
                // decrease energy by 2
                energy -= 2;
                // check again if dead
                if (energy <= 0) {
                    break;
                } else {
                    field[parisRow][parisCol] = '-';
                }
            }
            // if Helena encountered
            else if (nextCell == 'H') {
                // in place of Helena put -
                field[parisRow][parisCol] = '-';
                isGameWon = true;
                break;
            }
        }

        // printing output
        if(isGameWon){
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
        }else {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
        }

        // printing field
        for (int rowPrint = 0; rowPrint < field.length; rowPrint++) {
            for (int colPrint = 0; colPrint < field[rowPrint].length; colPrint++) {
                System.out.printf("%c", field[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }
}
