import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scanner.nextLine());
        Pattern validBarcodePattern = Pattern
                .compile("@#+(?<serial>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
        for (int i = 0; i < numOfLines; i++) {
            String barcode = scanner.nextLine();
            Matcher barcodeMatcher = validBarcodePattern.matcher(barcode);
            if(barcodeMatcher.find()){
                boolean isDefaultProductGroup = true;
                StringBuilder productGroup = new StringBuilder();
                String serial = barcodeMatcher.group("serial");
                for (int j = 0; j < serial.length(); j++) {
                    char thisChar = serial.charAt(j);
                    if(Character.isDigit(thisChar)){
                        isDefaultProductGroup = false;
                        productGroup.append(thisChar);
                    }
                }

                if(!isDefaultProductGroup){
                    System.out.printf("Product group: %s%n", productGroup);
                }else{
                    System.out.println("Product group: 00");
                }

            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}
