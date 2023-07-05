package solid;

import solid.products.Chocolate;
import solid.products.Coke;
import solid.products.Lemonade;
import solid.products.Product;

import java.util.List;

public class CalorieCalculator {
    public CalorieCalculator() {
    }

    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getCalories();
        }

        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
