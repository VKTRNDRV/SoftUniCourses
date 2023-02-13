import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacityPerHour = Integer.parseInt(scan.nextLine());
        capacityPerHour += Integer.parseInt(scan.nextLine());
        capacityPerHour += Integer.parseInt(scan.nextLine());
        int studentsInQueueCount = Integer.parseInt(scan.nextLine());
        int hoursPassed = 0;

        while(studentsInQueueCount > 0){

            hoursPassed++;
            if (hoursPassed % 4 != 0) {
                studentsInQueueCount -= capacityPerHour;
            }
        }

        System.out.printf("Time needed: %dh.", hoursPassed);
    }
}
