import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int playerRow = 7;
        int playerCol = 7;

        int playerHP = 18500;
        double heiganHP = 3000000;

        double playerHitDamage = Double.parseDouble(scan.nextLine());
        String lastSpell = "";
        while (true) {
            if (playerHP >= 0) {heiganHP -= playerHitDamage;}

            if (lastSpell.equals("Cloud")) {playerHP -= 3500;}

            if (heiganHP <= 0 || playerHP <= 0) {break;}

            String[] input = scan.nextLine().split(" ");
            String currSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);

            if (isInDmgArea(targetRow, targetCol, playerRow, playerCol)) {
                if (!isInDmgArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {
                    playerRow--;
                    lastSpell = "";
                } else if (!isInDmgArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {
                    playerCol++;
                    lastSpell = "";
                } else if (!isInDmgArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {
                    playerRow++;
                    lastSpell = "";
                } else if (!isInDmgArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {
                    playerCol--;
                    lastSpell = "";
                } else {
                    if (currSpell.equals("Cloud")) {
                        playerHP -= 3500;
                        lastSpell = "Cloud";
                    } else if (currSpell.equals("Eruption")) {
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = heiganHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHP);
        String playerState = playerHP <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHP);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }

    private static boolean isWall(int moveCell) {
        if(moveCell < 0 || moveCell >= 15){
            return true;
        }

        return false;
    }

    private static boolean isInDmgArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}
