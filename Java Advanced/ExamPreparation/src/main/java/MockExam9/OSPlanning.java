package MockExam9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading input
        int[] line1 = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int killTaskValue = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> allTasks = new ArrayDeque<>();
        ArrayDeque<Integer> allThreads = new ArrayDeque<>();
        for(int b : line1){allTasks.push(b);}
        for(int c : line2){allThreads.add(c);}

        // iterating until kill task reached
        while (true){
            int task = allTasks.peek();
            if(task == killTaskValue){
                break;
            }
            int thread = allThreads.peek();


            if(thread >= task){
                allTasks.pop();
            }

            allThreads.poll();
        }

        // printing output
        System.out.printf("Thread with value %d killed task %d\n", allThreads.peek(), killTaskValue);

        while (!allThreads.isEmpty()){
            System.out.printf("%d ", allThreads.poll());
        }
    }
}
