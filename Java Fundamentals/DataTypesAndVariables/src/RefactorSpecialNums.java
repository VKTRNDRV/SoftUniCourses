import java.util.Scanner;
public class RefactorSpecialNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int currentSum = 0;
        int currentNum = 0;
        boolean isSpecial = false;
        for (int ch = 1; ch <= num; ch++) {
            currentNum = ch;
            while (ch > 0) {
                currentSum += ch % 10;
                ch = ch / 10;
            }
            isSpecial = (currentSum == 5) || (currentSum == 7) || (currentSum == 11);
            if(isSpecial == true){
                System.out.printf("%d -> True%n", currentNum);
            }else{
                System.out.printf("%d -> False%n", currentNum);
            }
            currentSum = 0;
            ch = currentNum;
        }
    }
}
