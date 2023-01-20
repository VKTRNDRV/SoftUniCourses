import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int day1Yield = Integer.parseInt(scan.nextLine());
        int todaysYield = day1Yield;
        int totalYield = 0;
        int currentDay = 0;
        while(true){
            if(todaysYield >= 100) {
                totalYield += todaysYield;
                totalYield -= 26;
                currentDay++;
                todaysYield -= 10;
            }else{
                if(totalYield > 26) {
                    totalYield -= 26;
                }else{
                    totalYield = 0;
                }
                break;
            }
        }
        System.out.println(currentDay);
        System.out.println(totalYield);
    }
}
