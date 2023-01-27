import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arrayInput = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int[] arrayValidCombs = new int[arrayInput.length];
        Arrays.fill(arrayValidCombs,(Integer.MIN_VALUE+1));
        int combsFound = 0;
        int targetSum = Integer.parseInt(scan.nextLine());

        for (int i1 = 0; i1 < arrayInput.length-1; i1++){
            for (int i2 = i1 + 1; i2 < arrayInput.length; i2++){
                if(arrayInput[i1] + arrayInput[i2] == targetSum){

                    //checking if combination already present by checking if [i1] is present in arrayValidCombs
                    boolean isNewComb = true;
                    for (int i3 = 0; i3 < arrayValidCombs.length; i3++) {
                        if(arrayInput[i1] == arrayValidCombs[i3]){
                            isNewComb = false;
                            break;
                        }
                    }
                    if(isNewComb){
                        arrayValidCombs[combsFound*2] = arrayInput[i1];
                        arrayValidCombs[(combsFound*2)+1] = arrayInput[i2];
                        combsFound++;
                    }
                }
            }
        }
        for (int i = 0; i < arrayValidCombs.length; i+=2) {
            if(arrayValidCombs[i] != (Integer.MIN_VALUE+1)){
                System.out.printf("%d %d %n",arrayValidCombs[i],arrayValidCombs[i+1]);
            }
        }
    }
}
