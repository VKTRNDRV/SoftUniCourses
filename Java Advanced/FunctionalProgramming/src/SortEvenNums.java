import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(", "))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        numsList.removeIf(n -> n % 2 != 0);
        for (int i = 0; i < numsList.size(); i++) {
            if(i < numsList.size() - 1){
                System.out.print(numsList.get(i) + ", ");
            }else{
                System.out.println(numsList.get(i));
            }
        }

        numsList.sort(Integer::compareTo);
        for (int i = 0; i < numsList.size(); i++) {
            if(i < numsList.size() - 1){
                System.out.print(numsList.get(i) + ", ");
            }else{
                System.out.println(numsList.get(i));
            }
        }
    }
}