import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleInQueueCount = Integer.parseInt(scan.nextLine());

        List<Integer> liftWagonsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int wagonMaxCapacity = 4;
        boolean isLiftFull = false;

        while(peopleInQueueCount > 0){

            //checking every wagon for empty spots
            for (int j = 0; j < liftWagonsList.size(); j++) {
                int currentWagon = liftWagonsList.get(j);
                if(currentWagon < wagonMaxCapacity){
                    liftWagonsList.set(j, currentWagon + 1);
                    peopleInQueueCount -= 1;
                    break;
                }
            }

            //breaking loop if lift is full
            isLiftFull = true;
            for (int j = 0; j < liftWagonsList.size(); j++) {
                if(liftWagonsList.get(j) < wagonMaxCapacity){
                    isLiftFull = false;
                    break;
                }
            }
            if(isLiftFull){
                break;
            }
        }

        if(!isLiftFull && peopleInQueueCount == 0){
            System.out.println("The lift has empty spots!");
        }else if(isLiftFull && peopleInQueueCount != 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleInQueueCount);
        }

        for(int currentWagon : liftWagonsList){
            System.out.printf("%d ", currentWagon);
        }
    }
}
