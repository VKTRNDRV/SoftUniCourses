import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> elements = new LinkedHashSet<String>();
        int linesCount = Integer.parseInt(scanner.nextLine());
        while (linesCount > 0){
            String[] line = scanner.nextLine().split("\\s+");
            Arrays.stream(line)
                    .filter(s -> !elements.contains(s))
                    .forEach(elements::add);
            linesCount--;
        }

        elements.stream()
                .sorted(String::compareTo)
                .forEach(s -> System.out.printf("%s ", s));
    }
}
