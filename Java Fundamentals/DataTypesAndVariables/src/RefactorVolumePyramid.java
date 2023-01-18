import java.util.Scanner;

public class RefactorVolumePyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double baseLength, baseWidth, pyramidHeight, volume = 0;
        System.out.print("Length: ");
        baseLength = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        baseWidth = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        pyramidHeight = Double.parseDouble(scanner.nextLine());

        volume = (baseLength * baseWidth * pyramidHeight) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}
