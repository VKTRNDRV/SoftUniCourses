package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rectanglePointsCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();;

        Point bottomLeftPoint = new Point(rectanglePointsCoordinates[0], rectanglePointsCoordinates[1]);
        Point topRightPoint = new Point(rectanglePointsCoordinates[2], rectanglePointsCoordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);
        int pointsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < pointsCount; i++) {
            int[] pointArr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(s -> Integer.parseInt(s))
                    .toArray();;
            Point point = new Point(pointArr[0], pointArr[1]);
            System.out.println(rectangle.contains(point));
        }
    }

    public static int[] readIntArrFromConsole(){
        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
    }
}
