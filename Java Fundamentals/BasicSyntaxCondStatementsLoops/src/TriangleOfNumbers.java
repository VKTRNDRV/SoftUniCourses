import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        for (int l = 1; l <= num; l++){
            for(int r = 1; r <= l; r++){
                System.out.printf(Integer.toString(l) + " ");
            }
            System.out.println();
        }
    }
}
