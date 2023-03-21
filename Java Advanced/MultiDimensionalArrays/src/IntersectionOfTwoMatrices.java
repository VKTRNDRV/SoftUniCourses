import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension1 = Integer.parseInt(scanner.nextLine());
        int dimension2 = Integer.parseInt(scanner.nextLine());
        char[][] arr1 = new char[dimension1][dimension2];
        for (int i = 0; i < dimension1; i++) {
            String[] thisLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < dimension2; j++) {
                arr1[i][j] = thisLine[j].charAt(0);
            }
        }

        char[][] arr2 = new char[dimension1][dimension2];
        for (int i = 0; i < dimension1; i++) {
            String[] thisLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < dimension2; j++) {
                arr2[i][j] = thisLine[j].charAt(0);
            }
        }

        for (int i = 0; i < dimension1; i++) {
            for (int j = 0; j < dimension2; j++) {
                if(arr1[i][j] == arr2[i][j]){
                    System.out.printf("%c ", arr1[i][j]);
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
