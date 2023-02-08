import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfProducts = Integer.parseInt(scan.nextLine());
        List<String> productsList = new ArrayList<>();

        for (int i = 1; i <= numOfProducts; i++) {
            String currentProduct = scan.nextLine();
            productsList.add(currentProduct);
        }

        Collections.sort(productsList);

        for (int i = 1; i <= numOfProducts; i++) {
            String currentProduct = productsList.get(i-1);
            System.out.printf("%d.%s%n", i,currentProduct);
        }
    }
}
