import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNum = scan.nextLine();
        int smallNum = Integer.parseInt(scan.nextLine());
        while (bigNum.length() > 1 && bigNum.charAt(0) == '0') {
            bigNum = bigNum.substring(1);
        }

        StringBuilder output = new StringBuilder();
        int addOver = 0;
        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int thisInputDigit = Integer.parseInt(String.valueOf(bigNum.charAt(i)));
            int preliminaryResult = thisInputDigit * smallNum;
            int digitToBeAdded = (preliminaryResult + addOver) % 10;
            if(i != 0) {
                addOver = (preliminaryResult + addOver) / 10;
                output.insert(0, digitToBeAdded);
            }else{
                int lastNum = preliminaryResult + addOver;
                output.insert(0, lastNum);
            }
        }
        if(bigNum.charAt(0) != '0' && smallNum != 0) {
            System.out.println(output.toString());
        }else{
            System.out.println(0);
        }
    }
}
