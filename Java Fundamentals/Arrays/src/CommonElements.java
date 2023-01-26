import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr1 = scan.nextLine().split(" ");
        String[] arr2 = scan.nextLine().split(" ");

        for (int i2 = 0; i2 < arr2.length; i2++) {
            for (int i1 = 0; i1 < arr1.length; i1++) {

                if(arr2[i2].equals(arr1[i1])){
                    System.out.printf("%s ",arr2[i2]);
                }
            }
        }
    }
}
