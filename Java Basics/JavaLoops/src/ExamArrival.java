import java.util.Scanner;

public class ExamArrival {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* Read exam start time */
        int examHour = scan.nextInt();
        int examMinutes = scan.nextInt();
        // Read student arrival time
        int arrivalHour = scan.nextInt();
        int arrivalMinutes = scan.nextInt();

        // Calculate time difference
        int minsEarly = (examHour - arrivalHour) * 60 + (examMinutes - arrivalMinutes);

        // Print if student is early, on time, or late
        if (minsEarly > 30) {
            System.out.println("Early");
        } else if (minsEarly >= 0) {
            System.out.println("On time");
        } else {
            System.out.println("Late");
        }

        // Print if student is not exactly on time
        if(minsEarly > 0){
            if(minsEarly % 60 != 0) {
                if (minsEarly > 60) {
                    int hours = (int) Math.floor(minsEarly / 60);
                    int mins = minsEarly % 60;
                    if(mins >= 10) {
                        System.out.printf("%d:%d hours before the start", hours, mins);
                    }else{
                        System.out.printf("%d:0%d hours before the start", hours, mins);
                    }
                } else {
                    System.out.printf("%d minutes before the start", minsEarly);
                }
            }else{
                int hours = minsEarly / 60;
                System.out.printf("%d:00 hours before the start", hours);
            }
        }else if(minsEarly < 0){
            int minsLate = minsEarly * (-1);
            if(minsLate % 60 != 0) {
                if (minsLate >= 60) {
                    int hours = (int) Math.floor(minsLate / 60);
                    int mins = minsLate % 60;
                    if(mins >= 10) {
                        System.out.printf("%d:%d hours after the start", hours, mins);
                    }else{
                        System.out.printf("%d:0%d hours after the start", hours, mins);
                    }                } else {
                    System.out.printf("%d minutes after the start", minsLate);
                }
            }else{
                int hours = minsLate / 60;
                System.out.printf("%d:00 hours after the start", hours);
            }
        }
    }
}
