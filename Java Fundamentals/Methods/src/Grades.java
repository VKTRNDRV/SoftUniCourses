import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inputGrade = Double.parseDouble(scan.nextLine());

        String outputGrade = gradeCalculator(inputGrade);

        System.out.println(outputGrade);

    }

    public static String gradeCalculator(double input){
        if(input >= 2.00 && input < 3.00){
            return "Fail";

        }else if(input >= 3.00 && input < 3.50){
            return "Poor";

        }else if(input >= 3.50 && input < 4.50){
            return "Good";

        } else if (input >= 4.50 && input < 5.50){
            return "Very good";

        }else if (input >= 5.50 && input <= 6.00){
            return "Excellent";
        }
        return null;
    }
}
