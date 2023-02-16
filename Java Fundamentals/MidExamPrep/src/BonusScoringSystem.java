import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scan.nextLine());
        int lecturesCount = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());
        int maxAttendance = 0;
        double maxBonus = 0.0;

        for (int i = 0; i < studentsCount; i++){
            int currentAttendance = Integer.parseInt(scan.nextLine());

            double currentBonus = (double) currentAttendance / lecturesCount * (5 + additionalBonus);
            if(currentBonus > maxBonus){
                maxBonus = currentBonus;
                maxAttendance = currentAttendance;
            }
        }

        System.out.printf("Max Bonus: %d.%n", (int) Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendance);
    }
}
