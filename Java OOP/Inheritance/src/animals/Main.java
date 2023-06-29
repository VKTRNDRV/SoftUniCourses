package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            String animalType = scanner.nextLine();
            if (animalType.equals("Beast!")) {
                break;
            }

            String[] animalInfo = scanner.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);

            if(name.trim().isEmpty() || age < 0){
                System.out.println("Invalid input!\n");
                continue;
            }

            Animal animal = null;
            switch (animalType) {
                case "Dog":
                    String gender = animalInfo[2];
                    animal = new Dog(name, age, gender);
                    break;
                case "Cat":
                    String genderCat = animalInfo[2];
                    animal = new Cat(name, age, genderCat);
                    break;
                case "Frog":
                    String genderFrog = animalInfo[2];
                    animal = new Frog(name, age, genderFrog);
                    break;
                case "Kitten":
                    animal = new Kitten(name, age);
                    break;
                case "Tomcat":
                    animal = new Tomcat(name, age);
                    break;
            }

            animals.add(animal);
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
