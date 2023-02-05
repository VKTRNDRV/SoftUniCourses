import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double closestX = 0;
        double closestY = 0;

        double firstPointX = Double.parseDouble(scan.nextLine());
        double firstPointY = Double.parseDouble(scan.nextLine());
        double firstPointDistance = getDistanceToCenter(firstPointX, firstPointY);

        double secondPointX = Double.parseDouble(scan.nextLine());
        double secondPointY = Double.parseDouble(scan.nextLine());
        double secondPointDistance = getDistanceToCenter(secondPointX, secondPointY);

        if(firstPointDistance <= secondPointDistance){
            closestX = firstPointX;
            closestY = firstPointY;
        }else{
            closestX = secondPointX;
            closestY = secondPointY;
        }
        System.out.printf("(%.0f, %.0f)", closestX, closestY);
    }

    public static double getDistanceToCenter(double x, double y) {
        if (x < 0) {x *= -1;}
        if (y < 0) {y *= -1;}

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
