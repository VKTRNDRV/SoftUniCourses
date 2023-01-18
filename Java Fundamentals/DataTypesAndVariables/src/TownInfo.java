import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String townName = new String(scan.nextLine());
        int townPopulation = Integer.parseInt(scan.nextLine());
        int townAreaSqKm = Integer.parseInt(scan.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.", townName, townPopulation, townAreaSqKm);
    }
}
