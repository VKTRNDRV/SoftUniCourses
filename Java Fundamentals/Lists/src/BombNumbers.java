import javax.swing.plaf.metal.MetalTheme;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int bombNum = Integer.parseInt(scan.next());
        int bombPower = Integer.parseInt(scan.next());

        for (int i = 0; i < numsList.size(); i++) {

            if(numsList.get(i) == bombNum){
                bombExplode(numsList, i, bombPower);
                i = -1;
            }
        }

        int sum = 0;
        for (Integer currentNum : numsList) {
            sum += currentNum;
        }

        System.out.println(sum);
    }

    public static void bombExplode(List<Integer> list, int index, int power){
        int firstIndex = Math.max(index - power, 0);
        int lastIndex = Math.min(index + power, list.size()-1);
        for (int i = firstIndex; i <= lastIndex  ; i++) {
            list.remove(firstIndex);
        }
    }
}
