import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int firstSide = Integer.parseInt(scan.nextLine());
        int secondSide = Integer.parseInt(scan.nextLine());

        int area = getRectangleArea(firstSide,secondSide);

        System.out.println(area);

    }

    public static int getRectangleArea(int side1, int side2){
        return side1 * side2;
    }
}
