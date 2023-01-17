import java.util.Scanner;

public class CinemaRevenue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String projectionType = scan.nextLine();
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        double totalIncome = 0.0;
        //calculating totalIncome
        if ("Premiere".equals(projectionType)){
            totalIncome = rows * columns * 12;
        }else if ("Normal".equals(projectionType)){
            totalIncome = rows * columns * 7.50;
        }else if ("Discount".equals(projectionType)){
            totalIncome = rows * columns * 5.00;
        }

        System.out.printf("%.2f leva", totalIncome);
    }
}
