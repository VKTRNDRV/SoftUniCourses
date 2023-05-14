import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setsLength = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        Set<Integer> set1 = new LinkedHashSet<Integer>();
        Set<Integer> set2 = new LinkedHashSet<Integer>();

        for (int i = 0; i < setsLength[0]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if(!set1.contains(num)){
                set1.add(num);
            }
        }

        for (int i = 0; i < setsLength[1]; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if(!set2.contains(num)){
                set2.add(num);
            }
        }

        set1.stream()
                .filter(set2::contains)
                .forEach(n -> System.out.printf("%d ", n));

    }
}
