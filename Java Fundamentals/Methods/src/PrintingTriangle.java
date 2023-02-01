import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numInput = Integer.parseInt(scan.nextLine());

        printTriangle(numInput);

    }

    public static void printTriangle(int num){

        //ln = line number
        for (int ln = 1; ln <= num; ln++) {

            //cd = current digit
            for (int cd = 1; cd <= ln; cd++) {

                if(cd != ln){
                    System.out.printf(cd + " ");
                }else{
                    System.out.printf(cd + " %n");
                }
            }
        }

        //ln = line number
        for (int ln = num - 1; ln >= 1; ln--) {

            //cd = current digit
            for (int cd = 1; cd <= ln; cd++) {
                if(cd != ln){
                    System.out.printf(cd + " ");
                }else{
                    System.out.printf(cd + " %n");
                }
            }
        }
    }
}
