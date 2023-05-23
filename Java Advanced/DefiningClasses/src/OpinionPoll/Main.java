package OpinionPoll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (linesCount > 0){
            String[] line = scanner.nextLine().split("\\s+");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            if(person.getAge() > 30) {
                people.add(person);
            }
            linesCount--;
        }

       people = people
               .stream()
               .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
               .collect(Collectors.toList());

        for(Person person : people){
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}

