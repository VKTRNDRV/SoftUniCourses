import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerNums = readNumsFromConsole(scanner.nextLine());
        LinkedHashSet<Integer> secondPlayerNums = readNumsFromConsole(scanner.nextLine());
        for (int i = 0; i < 50; i++) {
            int firstPlayerNum = firstPlayerNums.iterator().next();
            firstPlayerNums.remove(firstPlayerNum);
            int secondPlayerNum = secondPlayerNums.iterator().next();
            secondPlayerNums.remove(secondPlayerNum);
            if(firstPlayerNum > secondPlayerNum){
                firstPlayerNums.add(firstPlayerNum);
                firstPlayerNums.add(secondPlayerNum);

            }else if(secondPlayerNum > firstPlayerNum){
                secondPlayerNums.add(firstPlayerNum);
                secondPlayerNums.add(secondPlayerNum);
            }else{
                firstPlayerNums.add(firstPlayerNum);
                secondPlayerNums.add(secondPlayerNum);
            }

            if(firstPlayerNums.isEmpty() || secondPlayerNums.isEmpty()){
                break;
            }
        }



        if(firstPlayerNums.isEmpty()){
            System.out.println("Second player win!");

        } else if (secondPlayerNums.isEmpty()) {
            System.out.println("First player win!");

        }else{
            if(firstPlayerNums.size() > secondPlayerNums.size()){
                System.out.println("First player win!");

            }else if(secondPlayerNums.size() > firstPlayerNums.size()){
                System.out.println("Second player win!");

            }else{
                System.out.println("Draw!");

            }
        }
    }

    public static LinkedHashSet<Integer> readNumsFromConsole(String line){
        int[] tempArr = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        LinkedHashSet<Integer> numsSet = new LinkedHashSet<>();
        for(int num : tempArr){
            numsSet.add(num);
        }

        return numsSet;
    }
}
