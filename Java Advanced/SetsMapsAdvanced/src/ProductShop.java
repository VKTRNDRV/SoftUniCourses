import java.util.*;
import java.util.stream.Collectors;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shopsMap = new HashMap<>();
        while (true){
            String[] productArr = scanner.nextLine().split(", ");
            if(productArr[0].equals("Revision")){break;}
            String shopName = productArr[0];
            String productName = productArr[1];
            double productPrice = Double.parseDouble(productArr[2]);

            if(!shopsMap.containsKey(shopName)){
                shopsMap.put(shopName, new LinkedHashMap<>());
            }

            shopsMap.get(shopName).put(productName, productPrice);
        }

        LinkedHashMap<String, Map<String, Double>> sortedShopsMap = shopsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for(Map.Entry<String, Map<String, Double>> shopEntry : sortedShopsMap.entrySet()){
            System.out.printf("%s->%n", shopEntry.getKey());

            for(Map.Entry<String, Double> productEntry : shopEntry.getValue().entrySet()){
                System.out.printf("Product: %s, Price: %.1f%n", productEntry.getKey(), productEntry.getValue());
            }
        }
    }
}
