import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kidsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int leaveNum = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        for(String kid : kidsList){
            kidsQueue.add(kid);
        }

        for (int i = 1; kidsQueue.size() > 1; i++){
            String thisKid = kidsQueue.remove();
            if(i % leaveNum == 0){
                System.out.printf("Removed %s%n", thisKid);
            }else{
                kidsQueue.add(thisKid);
            }
        }

        System.out.printf("Last is %s%n", kidsQueue.peek());
    }
}
