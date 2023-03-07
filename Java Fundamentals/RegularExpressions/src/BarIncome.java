import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalIncome = 0.0;
        Pattern orderPattern = Pattern.compile
                ("(?<name>%[A-Z][a-z]+%)[^|$%.]*(?<product><\\w+>)[^|$%.]*(?<count>[|]\\d+[|])[^|$%.0123456789]*(?<price>\\d+[.]?\\d*[$])");
        while (true){
            String line = scan.nextLine();
            if(line.equals("end of shift")){break;}
            Matcher orderMatcher = orderPattern.matcher(line);
            if(orderMatcher.find()){
                String name = orderMatcher.group("name");
                name = name.substring(1, name.length() - 1);

                String product = orderMatcher.group("product");
                product = product.substring(1, product.length() - 1);

                String count = orderMatcher.group("count");
                count = count.substring(1, count.length() - 1);

                String price = orderMatcher.group("price");
                price = price.substring(0, price.length() - 1);

                double orderTotal = Double.parseDouble(count) * Double.parseDouble(price);
                totalIncome += orderTotal;
                System.out.printf("%s: %s - %.2f%n", name, product, orderTotal);
            }
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
