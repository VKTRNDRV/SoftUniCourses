import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scan.nextLine());

        while (true){
            String[] currentCommand = scan.nextLine().split(" ");
            if(currentCommand[0].equals("end")){break;}

            switch (currentCommand[0]){
                case "Add":
                    wagonsList.add(Integer.parseInt(currentCommand[1]));
                    break;

                default:
                    int newPassengers = Integer.parseInt(currentCommand[0]);
                    for (int i = 0; i < wagonsList.size(); i++){
                        if(wagonsList.get(i) + newPassengers <= maxCapacity){
                            wagonsList.set(i, wagonsList.get(i) + newPassengers);
                            break;
                        }
                    }
                    break;
            }
        }

        for(int currentWagon : wagonsList){
            System.out.printf("%d ", currentWagon);
        }
    }
}
