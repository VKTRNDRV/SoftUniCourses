import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            char thisChar = text.charAt(i);
            if(Character.isDigit(thisChar)){
                digits.append(thisChar);
            }else if(Character.isLetter(thisChar)){
                letters.append(thisChar);
            }else {
                others.append(thisChar);
            }
        }

        System.out.println(digits.toString());
        System.out.println(letters.toString());
        System.out.println(others.toString());
    }
}
