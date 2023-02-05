import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String dataType = scan.nextLine();

        switch (dataType){
            case "int":
                int numInt = Integer.parseInt(scan.nextLine());
                numInt = processInput(numInt);
                System.out.println(numInt);
                break;

            case "real":
                double numDouble = Double.parseDouble(scan.nextLine());
                numDouble = processInput(numDouble);
                System.out.printf("%.2f",numDouble);
                break;

            case "string":
                String string = scan.nextLine();
                string = processInput(string);
                System.out.println(string);
                break;
        }
    }

    public static int processInput(int num){
        return num*2;
    }

    public static double processInput(double num){
        return  num * 1.5;
    }

    public static String processInput(String input){
        String output = "$";

        output += input;
        output += "$";
        return output;
    }
}
