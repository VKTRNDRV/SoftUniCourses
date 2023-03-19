import java.util.*;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kidsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int leaveNum = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> kidsQueue = new PriorityQueue<>(kidsList);

        int cycle = 1;
        while (kidsQueue.size() > 1) {
            for (int i = 1; i < leaveNum; i++)
                kidsQueue.offer(kidsQueue.poll());
            if (isPrime(cycle))
                System.out.println("Prime " + kidsQueue.peek());
            else
                System.out.println("Removed " + kidsQueue.poll());
            cycle++;
        }
        System.out.println("Last is " + kidsQueue.poll());

    }

    public static boolean isPrime(int n){
        if (n == 2 || n == 3) {return true;}

        if (n <= 1 || n % 2 == 0 || n % 3 == 0){return false;}

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}
