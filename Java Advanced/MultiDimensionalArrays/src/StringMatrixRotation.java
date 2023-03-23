import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //reading degrees
        Pattern numPattern = Pattern.compile("\\d+");
        String degreesStr = scanner.nextLine();
        Matcher numMatcher = numPattern.matcher(degreesStr);
        if(numMatcher.find()) {
            degreesStr = numMatcher.group();
        }
        int degrees = Integer.parseInt(degreesStr);
        degrees = degrees % 360;

        //reading elements
        List<String> linesList = new ArrayList<>();
        while (true){
            String thisLine = scanner.nextLine();
            if(thisLine.equals("END")){break;}
            linesList.add(thisLine);
        }

        //calc col length as per longest string
        int maxLength = 0;
        for (String str : linesList) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        //filling out array
        char[][] initialArray = new char[linesList.size()][maxLength];
        for(int i = 0; i < linesList.size(); i++){
            String thisStr = linesList.get(i);
            for (int j = 0; j < maxLength; j++) {
                if(j < thisStr.length()){
                    initialArray[i][j] = thisStr.charAt(j);
                }else{
                    initialArray[i][j] = ' ';
                }
            }
        }

        if(degrees == 0){
            print00(initialArray);
        } else if (degrees == 90) {
            print90(initialArray);
        } else if (degrees == 180) {
            print180(initialArray);
        } else if (degrees == 270) {
            print270(initialArray);
        }

    }

    public static void print00(char[][] array){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                System.out.printf("%c", array[row][col]);
            }
            System.out.println();
        }
    }

    public static void print90(char[][] array){
        for (int col = 0; col < array[0].length; col++) {
            for (int row = array.length - 1; row >= 0; row--) {
                System.out.printf("%c", array[row][col]);
            }
            System.out.println();
        }
    }

    public static void print180(char[][] array){
        for (int row = array.length - 1; row >= 0; row--) {
            for (int col = array[0].length - 1; col >= 0; col--) {
                System.out.printf("%c", array[row][col]);
            }
            System.out.println();
        }
    }

    public static void print270(char[][] array){
        for (int col = array[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < array.length; row++) {
                System.out.printf("%c", array[row][col]);
            }
            System.out.println();
        }
    }
}
