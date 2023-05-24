package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true){
            String[] data = scanner.nextLine().split("\\s+");
            if(data[0].equals("End")){break;}

            String personName = data[0];
            String command = data[1];
            String objectName = data[2];
            String objectParameter = data[3];
            double salary = 0;
            if(data.length == 5){
                salary = Double.parseDouble(data[4]);
            }

            Person person = null;
            for(Person p : people){
                if(p.getName().equals(personName)){
                    person = p;
                    break;
                }
            }
            if(person == null){
                person = new Person(personName);
                people.add(person);
            }

            switch (command){
                case "company":
                    person.setCompany(new Company(objectName, objectParameter, salary));
                    break;

                case "pokemon":
                    person.addPokemon(new Pokemon(objectName, objectParameter));
                    break;

                case "parents":
                    person.addParent(new Parent(objectName, objectParameter));
                    break;

                case "children":
                    person.addChild(new Child(objectName, objectParameter));
                    break;

                case "car":
                    person.setCar(new Car(objectName, Integer.parseInt(objectParameter)));
                    break;
            }
        }

        String personName = scanner.nextLine();
        Person person;
        for(Person p : people){
            if(p.getName().equals(personName)){
                person = p;
                System.out.println(person.toString());
                break;
            }
        }
    }
}
