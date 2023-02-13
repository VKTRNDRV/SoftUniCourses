import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> targetsList = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int targetsShotCount = 0;

        while (true){
            String currentInput = scan.nextLine();
            if(currentInput.equals("End")){
                break;
            }
            int currentShotIndex = Integer.parseInt(currentInput);

            if(isShotValid(targetsList, currentShotIndex)){
                adjustValues(targetsList, currentShotIndex);
                targetsShotCount++;
            }
        }

        System.out.printf("Shot targets: %d -> ", targetsShotCount);
        for (int currentElement: targetsList) {
            System.out.printf("%d ", currentElement);
        }
    }

    public static boolean isShotValid(List<Integer> list, int index){
        boolean isValid = true;
        if(index < 0 || index >= list.size()){
            isValid = false;

        } else if (list.get(index) == -1) {
            isValid = false;
        }

        return isValid;
    }

    public static void adjustValues(List<Integer> list, int index){
        int shotTargetValue = list.get(index);
        list.set(index, -1);

        for(int i = 0; i < list.size(); i++){
            int currentElement = list.get(i);
            if(currentElement != -1){
                if(currentElement > shotTargetValue){
                    list.set(i, currentElement - shotTargetValue);
                }else{
                    list.set(i, currentElement + shotTargetValue);
                }
            }
        }
    }
}
