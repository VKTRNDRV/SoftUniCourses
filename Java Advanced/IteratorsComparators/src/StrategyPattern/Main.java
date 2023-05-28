package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        Set<Person> firstSet = new TreeSet<>(new PersonNameComparator());
        Set<Person> secondSet = new TreeSet<>(new PersonAgeComparator());
        while (peopleCount > 0){
            String[] params = scanner.nextLine().split("\\s+");
            Person person = new Person(params[0], Integer.parseInt(params[1]));
            firstSet.add(person);
            secondSet.add(person);
            peopleCount--;
        }

        for(Person person : firstSet){
            System.out.printf("%s %d%n", person.getName(), person.getAge());
        }

        for(Person person : secondSet){
            System.out.printf("%s %d%n", person.getName(), person.getAge());
        }
    }
}
