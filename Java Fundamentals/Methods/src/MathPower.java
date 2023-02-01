import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inputNum = Double.parseDouble(scan.nextLine());
        int inputPow = Integer.parseInt(scan.nextLine());

        double result = pow(inputNum,inputPow);

        System.out.println(new DecimalFormat("0.####").format(result));

    }

    public static double pow(double num, int pow){

        double result = 1;
        if(pow == 0){
            return result;

        }else if(pow > 0) {
            for (int i = 1; i <= pow; i++) {
                result *= num;
            }
        //if pow < 0
        }else{
            for (int i = 1; i <= (pow * -1); i++) {
                result *= num;
            }
            result = 1 / result;
        }

        return result;
    }
}
