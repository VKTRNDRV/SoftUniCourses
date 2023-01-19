import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int totalLines = Integer.parseInt(scan.nextLine());
        int currentLitersInTank = 0;
        int maxCapacity = 255;

        for (int i = 1; i <= totalLines; i++) {
            int currentInputLiters = Integer.parseInt(scan.nextLine());

            if(currentLitersInTank + currentInputLiters <= maxCapacity){
                currentLitersInTank += currentInputLiters;
            }else{
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(currentLitersInTank);
    }
}
