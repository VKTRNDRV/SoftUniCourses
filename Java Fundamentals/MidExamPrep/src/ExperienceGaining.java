import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double targetExperience = Double.parseDouble(scan.nextLine());
        int totalBattles = Integer.parseInt(scan.nextLine());

        int battlesCount = 0;
        double totalExperience = 0;
        for (int i = 1; i <= totalBattles; i++) {
            double currentBattleExperience = Double.parseDouble(scan.nextLine());

            battlesCount++;
            totalExperience += currentBattleExperience;

            if(battlesCount % 3 == 0 && battlesCount != 0){
                totalExperience += (currentBattleExperience * 0.15);
            }
            if(battlesCount % 5 == 0 && battlesCount != 0){
                totalExperience -= (currentBattleExperience * 0.10);
            }

            if(totalExperience >= targetExperience){
                break;
            }
        }

        if(totalExperience >= targetExperience){
            System.out.printf("Player successfully collected his needed experience for %d battles.", battlesCount);

        }else{
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", (targetExperience - totalExperience));
        }
    }
}
