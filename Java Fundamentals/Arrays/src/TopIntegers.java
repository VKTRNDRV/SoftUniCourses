import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        for (int currentElement = 0; currentElement < array.length; currentElement++) {
            if(currentElement != array.length-1){
                boolean isBigger = true;
                for (int i = currentElement+1; i < array.length; i++) {
                    if(array[currentElement] <= array[i]){
                        isBigger = false;
                        break;
                    }
                }
                if(isBigger){
                    System.out.printf("%d ",array[currentElement]);
                }
            }else{
                System.out.printf("%d",array[currentElement]);
            }
        }
    }
}
