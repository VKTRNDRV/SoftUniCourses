import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> housesList = Arrays.stream(scan.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int currentIndex = 0;
        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("Love!")){
                break;
            }

            int currentCommandIndex = Integer.parseInt(currentCommand[1]);
            currentIndex += currentCommandIndex;
            if(currentIndex >= housesList.size()){
                currentIndex = 0;
            }

            int currentHouse = housesList.get(currentIndex);
            if(currentHouse <= 0){
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }else{

                housesList.set(currentIndex, currentHouse - 2);
                if(housesList.get(currentIndex) == 0){
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            }
        }

        boolean isMissionSuccessful = true;
        int failedHousesCount = 0;
        for(int currentHouse : housesList){
            if(currentHouse > 0){
                failedHousesCount++;
                isMissionSuccessful = false;
            }
        }

        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        if(isMissionSuccessful){
            System.out.print("Mission was successful.");
        }else{
            System.out.printf("Cupid has failed %d places.", failedHousesCount);
        }
    }
}
