import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int totalDaysPlunder = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double targetPlunder = Double.parseDouble(scan.nextLine());

        double totalPlunder = 0;

        for (int i = 0; i < totalDaysPlunder ; i++) {
            int currentDay = i + 1;
            totalPlunder += dailyPlunder;

            if(currentDay % 3 == 0){
                totalPlunder += (dailyPlunder * 0.5);
            }
            if(currentDay % 5 == 0){
                totalPlunder *= 0.7;
            }
        }

        if(totalPlunder >= targetPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        }else{
            double percentPlundered = 100*(totalPlunder/targetPlunder);
            if(percentPlundered >= 100){
                percentPlundered = 0;
            }
            System.out.printf("Collected only %.2f%% of the plunder.", percentPlundered);
        }
    }
}
