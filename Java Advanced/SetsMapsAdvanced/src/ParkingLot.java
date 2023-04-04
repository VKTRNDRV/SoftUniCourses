import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        while (true){
            String[] inputArr = scanner.nextLine().split(", ");
            if(inputArr[0].equals("END")){break;}
            String carNumStr = inputArr[1];
            if(inputArr[0].equals("IN")){
                parkingLot.add(carNumStr);
            } else if (inputArr[0].equals("OUT")) {
                parkingLot.remove(carNumStr);
            }
        }

        if(!parkingLot.isEmpty()){
            parkingLot.forEach(str -> System.out.println(str));

        }else{
            System.out.println("Parking Lot is Empty");
        }
    }
}