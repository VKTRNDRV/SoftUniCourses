package defineInterfacePerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> buyers = new ArrayList<>();
        int buyersCount = Integer.parseInt(scanner.nextLine());

        // read buyers
        String input = scanner.nextLine();
        while (buyersCount > 0) {
            String[] tokens = input.split("\\s+");

            int type = tokens.length;
            if (type == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];
                buyers.add(new Citizen(name, age, id, birthDate));

            }else if (type == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                buyers.add(new Rebel(name, age, group));
            }

            input = scanner.nextLine();
            buyersCount--;
        }

        // read names
        int foodAdded = 0;
        while (!input.equals("End")){

            // make move if name found
            for(Person person : buyers){
                if(person.getName().equals(input)){
                    ((Buyer) person).buyFood();

                    // update foodAdded
                    Class<? extends Person> personClass = person.getClass();
                    if(personClass.equals(Citizen.class)){
                        foodAdded += 10;
                    } else if (personClass.equals(Rebel.class)) {
                        foodAdded += 5;
                    }
                    break;
                }
            }

            input = scanner.nextLine();
        }

        //print foodAdded
        System.out.println(foodAdded);
    }
}







