import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String dataType = scan.nextLine();
        String firstItem = scan.nextLine(); 
        String secondItem = scan.nextLine();

        String output = getMax(dataType,firstItem,secondItem);

        System.out.println(output);
    }

    public static String getMax(String dataType, String item1, String item2){

        switch (dataType){
            case "int":
                int num1 = Integer.parseInt(item1);
                int num2 = Integer.parseInt(item2);
                if(num1 > num2){
                    return item1;
                }else{
                    return item2;
                }
            case "char":
                char char1 = item1.charAt(0);
                char char2 = item2.charAt(0);

                if(char1 > char2){
                    return item1;
                }else{
                    return item2;
                }
            case "string":
                int result = item1.compareTo(item2);
                if(result < 0){
                    return item2;
                }else{
                    return item1;
                }
            default:
                return "Invalid Datatype";
        }
    }
}
