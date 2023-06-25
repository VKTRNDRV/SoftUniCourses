package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setMoney(double money){
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private void setName(String name){
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void buyProduct(Product product){
        if(product.getCost() > money){
            throw new IllegalArgumentException(
                    String.format("%s can't afford %s"
                            , this.getName()
                            , product.getName())
            );
        }

        this.products.add(product);
        this.money -= product.getCost();
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(" - ");
        if(this.products.isEmpty()){
            output.append("Nothing bought");
            return output.toString();
        }

        int i = 0;
        while (i < this.products.size() - 1) {
            output.append(this.products.get(i).getName()).append(", ");
            i++;
        }
        output.append(this.products.get(i).getName());
        return output.toString();
    }
}
