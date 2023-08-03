package christmasPastryShop.entities.delicacies;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public abstract class BaseDelicacy implements Delicacy {

    private String name;

    private double portion;

    private double price;


    public BaseDelicacy(String name, double portion, double price){
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_NAME);
        }
        this.name = name;
    }

    protected void setPortion(double portion) {
        if(portion <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_PORTION);
        }
        this.portion = portion;
    }

    protected void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return String.format("%s: %.2fg - %.2flv",
                name, portion, price);
    }
}
