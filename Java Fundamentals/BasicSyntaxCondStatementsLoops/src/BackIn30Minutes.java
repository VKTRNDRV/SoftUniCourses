import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hoursInput = Integer.parseInt(scan.nextLine());
        int minsInput = Integer.parseInt(scan.nextLine());

        int hoursOutput = hoursInput;
        int minsOutput = minsInput += 30;

        if(minsOutput >= 60){
            hoursOutput ++;
            minsOutput -= 60;
        }
        if(hoursOutput >= 24){
            hoursOutput = 0;
        }

        System.out.printf("%d:%02d",hoursOutput,minsOutput);

    }
}
