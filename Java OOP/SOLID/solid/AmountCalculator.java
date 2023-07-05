package solid;

import solid.products.Product;

import java.util.Collection;

public class AmountCalculator {

    public double getTotalAmount(Collection<Product> products){
        double total = 0;
        for(Product product : products){
            total += product.getAmount();
        }
        return total;
    }

    public double getAverageAmount(Collection<Product> products){
        return getTotalAmount(products) / products.size();
    }
}
