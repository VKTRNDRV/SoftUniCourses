import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int[] triangleArr = new int[101];
        triangleArr[0] = 1;

        System.out.printf(1 + " %n");
        //iterating as much as input requested
        for (int i = 1; i < num; i++){
            //creating a temporary array for the new line
            int[] tempArr = new int[triangleArr.length];
            tempArr[0] = 1;
            //calculating new tempArr
            for (int currEl = 1; currEl <= i; currEl++) {
                tempArr[currEl] = triangleArr[currEl-1] + triangleArr[currEl];
            }

            //assigning tempArr values to triangleArr and printing to console
            for (int j = 0; j <= i; j++) {
                triangleArr[j] = tempArr[j];
                if(j != i){
                    System.out.printf(triangleArr[j] + " ");
                }else{
                    System.out.printf("%d %n",triangleArr[j]);
                }
            }
        }
    }
}
