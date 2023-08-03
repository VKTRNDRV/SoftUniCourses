package christmasPastryShop.entities.cocktails;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public abstract class BaseCocktail implements Cocktail {

    private String name;

    private int size;

    private double price;

    private String brand;


    public BaseCocktail(String name, int size, double price, String brand){
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }


    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_NAME);
        }
        this.name = name;
    }

    protected void setSize(int size) {
        if(size <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_SIZE);
        }
        this.size = size;
    }

    protected void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_PRICE);
        }
        this.price = price;
    }

    protected void setBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString(){
        return String.format("%s %s - %dml - %.2flv",
                name, brand, size, price);
    }
}
