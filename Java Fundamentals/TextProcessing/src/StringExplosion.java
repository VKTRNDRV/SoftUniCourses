import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder string = new StringBuilder();
        string.append(scan.nextLine());

        int deleteCount = 0;
        for (int i = 0; i < string.length(); i++) {
            char thisChar = string.charAt(i);
            if(thisChar == '>'){
                deleteCount += Integer.parseInt(String.valueOf(string.charAt(i+1)));
                i++;
            }
            if(deleteCount > 0){
                string.deleteCharAt(i);
                deleteCount--;
                i--;
            }
        }

        System.out.println(string.toString());
    }
}
