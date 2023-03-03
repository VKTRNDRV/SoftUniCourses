import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] twoStrArr = scan.nextLine().split(" ");
        String str1 = twoStrArr[0];
        String str2 = twoStrArr[1];
        System.out.println(multiplyChars(str1, str2));
    }

    public static int multiplyChars(String string1, String string2){
        String shorterString;
        String longerString;
        if(string1.length() <= string2.length()){
            shorterString = string1;
            longerString = string2;
        }else{
            shorterString = string2;
            longerString = string1;
        }
        int sum = 0;
        for (int i = 0; i < longerString.length(); i++) {
            if(i < shorterString.length()){
                sum += shorterString.charAt(i) * longerString.charAt(i);
            }else{
                sum += longerString.charAt(i);
            }
        }
        return sum;
    }
}
