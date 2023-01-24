import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String daysOfWeek[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int inputNum = Integer.parseInt(scan.nextLine());
        if(inputNum >= 1 && inputNum <= 7){
            System.out.printf(daysOfWeek[inputNum-1]);
        }else{
            System.out.println("Invalid day!");
        }
    }
}
