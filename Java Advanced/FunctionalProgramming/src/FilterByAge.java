import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> peopleMap = new LinkedHashMap<>();
        for (int i = 0; i <peopleCount ; i++) {
            String[] personArr = scanner.nextLine().split(", ");
            peopleMap.put(personArr[0], Integer.parseInt(personArr[1]));
        }
        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition, ageCondition);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(peopleMap, tester, printer);


    }

    public static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;

            case "name":
                printer = person -> System.out.printf("%s%n", person.getKey());
                break;

            case "age":
                printer = person -> System.out.printf("%d%n", person.getValue());
        }
        return printer;
    }

    public static Predicate<Integer> createTester(String condition, int age){
        Predicate<Integer> tester = null;
        switch (condition){
            case "younger":
                tester = x -> x <= age;
                break;

            case "older":
                tester = x -> x >= age;
                break;
        }

        return tester;
    }

    static void printFilteredStudent(LinkedHashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }

}
