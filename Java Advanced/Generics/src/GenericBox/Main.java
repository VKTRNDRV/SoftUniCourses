package GenericBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int itemsCount = Integer.parseInt(scanner.nextLine());
        List<Double> doubles = new ArrayList<>();
        while (itemsCount > 0){
            double str = Double.parseDouble(scanner.nextLine());
            doubles.add(str);
            itemsCount--;
        }

        Double testItem = Double.parseDouble(scanner.nextLine());

        System.out.println(Box.countGreater(doubles, testItem));
    }
}
