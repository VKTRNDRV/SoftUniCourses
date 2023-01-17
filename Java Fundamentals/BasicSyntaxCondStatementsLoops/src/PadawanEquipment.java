import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalBudget = Double.parseDouble(scan.nextLine());
        int numOfStudents = Integer.parseInt(scan.nextLine());
        double lightsaberPrice = Double.parseDouble(scan.nextLine());
        double robePrice = Double.parseDouble(scan.nextLine());
        double beltPrice = Double.parseDouble(scan.nextLine());

        double totalPrice = (Math.ceil(numOfStudents*1.1) * lightsaberPrice) +
                            (numOfStudents * robePrice) +
                            ((numOfStudents-Math.floor(numOfStudents/6)) * beltPrice);

        if(totalBudget >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }else{
            System.out.printf("George Lucas will need %.2flv more.",(totalPrice - totalBudget));
        }
    }
}
