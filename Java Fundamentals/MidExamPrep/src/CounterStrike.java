import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int energyLeft = Integer.parseInt(scan.nextLine());
        int battlesWonCount = 0;
        boolean isGameWon = true;

        while(true){
            String currentInput = scan.nextLine();
            if(currentInput.equals("End of battle")){
                break;
            }

            int currentEnemyEnergy = Integer.parseInt(currentInput);

            if(currentEnemyEnergy <= energyLeft){
                energyLeft -= currentEnemyEnergy;
                battlesWonCount++;
            }else{
                isGameWon = false;
                break;
            }

            if(battlesWonCount % 3 == 0){
                energyLeft += battlesWonCount;
            }
        }

        if(isGameWon){
            System.out.printf("Won battles: %d. Energy left: %d", battlesWonCount, energyLeft);
        }else{
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWonCount, energyLeft);
        }
    }
}
