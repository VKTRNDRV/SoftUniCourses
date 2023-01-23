import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pokePower = Integer.parseInt(scan.nextLine());
        int currentPokePower = pokePower;
        int distanceBtwTargets = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());
        int numOfPokes = 0;

        while(currentPokePower >= distanceBtwTargets){

            currentPokePower -= distanceBtwTargets;
            numOfPokes++;

            if(currentPokePower == pokePower / 2){
                if(exhaustionFactor != 0){
                    currentPokePower = currentPokePower/exhaustionFactor;
                }
            }
        }
        System.out.println(currentPokePower);
        System.out.println(numOfPokes);
    }
}
