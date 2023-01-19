import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int totalPeople = Integer.parseInt(scan.nextLine());
        int elevatorCapacity = Integer.parseInt(scan.nextLine());

        int tripsNeeded = (int) Math.ceil((double)totalPeople/elevatorCapacity);

        System.out.println(tripsNeeded);
    }
}
