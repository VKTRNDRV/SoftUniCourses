package animalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        try {
            Chicken chicken = new Chicken(name, age);
            System.out.print(chicken.toString());

        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
