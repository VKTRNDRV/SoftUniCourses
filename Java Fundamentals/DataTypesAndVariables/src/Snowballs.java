import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfSnowballs = Integer.parseInt(scan.nextLine());
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;
        double bestSnowballValue = Double.MIN_VALUE;

        for (int i = 1; i <= numOfSnowballs ; i++){
            int currentSnowballSnow = Integer.parseInt(scan.nextLine());
            int currentSnowballTime = Integer.parseInt(scan.nextLine());
            int currentSnowballQuality = Integer.parseInt(scan.nextLine());

            double currentSnowBallValue = Math.pow(currentSnowballSnow/currentSnowballTime,currentSnowballQuality);

            if(currentSnowBallValue > bestSnowballValue){
                bestSnowballSnow = currentSnowballSnow;
                bestSnowballTime = currentSnowballTime;
                bestSnowballQuality = currentSnowballQuality;
                bestSnowballValue = currentSnowBallValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",bestSnowballSnow,bestSnowballTime,bestSnowballValue,bestSnowballQuality);
    }
}
