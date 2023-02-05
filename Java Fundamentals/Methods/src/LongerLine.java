import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double firstPointX = Double.parseDouble(scan.nextLine());
        double firstPointY = Double.parseDouble(scan.nextLine());
        double secondPointX = Double.parseDouble(scan.nextLine());
        double secondPointY = Double.parseDouble(scan.nextLine());

        double thirdPointX = Double.parseDouble(scan.nextLine());
        double thirdPointY = Double.parseDouble(scan.nextLine());
        double fourthPointX = Double.parseDouble(scan.nextLine());
        double fourthPointY = Double.parseDouble(scan.nextLine());


        //assigning first line's points
        double firstLineX1 = 0;
        double firstLineY1 = 0;
        double firstLineX2 = 0;
        double firstLineY2 = 0;
        if(getDistanceToCenter(firstPointX,firstPointY) <= getDistanceToCenter(secondPointX,secondPointY)){
            firstLineX1 = firstPointX;
            firstLineY1 = firstPointY;

            firstLineX2 = secondPointX;
            firstLineY2 = secondPointY;

        }else{
            firstLineX1 = secondPointX;
            firstLineY1 = secondPointY;

            firstLineX2 = firstPointX;
            firstLineY2 = firstPointY;
        }

        //assigning second line's points
        double secondLineX1 = 0;
        double secondLineY1 = 0;
        double secondLineX2 = 0;
        double secondLineY2 = 0;
        if(getDistanceToCenter(thirdPointX,thirdPointY) <= getDistanceToCenter(fourthPointX,fourthPointY)){
            secondLineX1 = thirdPointX;
            secondLineY1 = thirdPointY;

            secondLineX2 = fourthPointX;
            secondLineY2 = fourthPointY;

        }else{
            secondLineX1 = fourthPointX;
            secondLineY1 = fourthPointY;

            secondLineX2 = thirdPointX;
            secondLineY2 = thirdPointY;
        }

        double firstLineLength = getLineLength(firstLineX1,firstLineY1, firstLineX2,firstLineY2);
        double secondLineLength = getLineLength(secondLineX1,secondLineY1, secondLineX2,secondLineY2);

        if(firstLineLength >= secondLineLength){
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", firstLineX1, firstLineY1, firstLineX2, firstLineY2);
        }else{
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", secondLineX1, secondLineY1, secondLineX2, secondLineY2);
        }
    }

    public static double getDistanceToCenter(double x, double y) {
        if (x < 0) {x *= -1;}
        if (y < 0) {y *= -1;}

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double getLineLength(double x1, double y1, double x2, double y2){

        double sideA = x2 - x1;
        if(sideA < 0){sideA *= -1;}

        double sideB = y2 - y1;
        if(sideB < 0){sideB *= -1;}

        return Math.sqrt(Math.pow(sideA,2) + Math.pow(sideB,2));
    }
}
