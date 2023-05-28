package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        while (true){
            String[] params = scanner.nextLine().split("\\s+");
            if(params[0].equals("END")){break;}
            Person person = new Person(params[0], Integer.parseInt(params[1]), params[2]);
            people.add(person);
        }

        Person testPerson = people.get(Integer.parseInt(scanner.nextLine()) - 1);
        people.remove(testPerson);
        int equalCount = 0;
        for(Person person : people){
            if(person.compareTo(testPerson) == 0){
                equalCount++;
            }
        }

        if(equalCount == 0){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d",
                    equalCount + 1,
                    people.size() - equalCount,
                    people.size() + 1);
        }

    }
}
