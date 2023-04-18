package SquareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int num = Integer.parseInt(scanner.nextLine());
            double sqrt = Math.sqrt(num);
            if(Double.isNaN(sqrt)){
                throw new Exception();
            }
            System.out.printf("%.2f%n", sqrt);

        }catch (Exception e){
            System.out.println("Invalid");

        }finally {
            System.out.println("Goodbye");
        }
    }
}
