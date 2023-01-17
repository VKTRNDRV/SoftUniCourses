import java.util.Scanner;

public class InchesToCM {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float inputInches = Float.parseFloat(scanner.nextLine());
        float inchesToCM = 2.54F;
        float outputInches = inputInches * inchesToCM;
        System.out.println(outputInches);

    }
}
