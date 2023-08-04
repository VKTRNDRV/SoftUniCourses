package robotService.entities.robot;

import robotService.common.ExceptionMessages;

public abstract class BaseRobot implements Robot{

    private String name;

    private String kind;

    private int kilograms;

    private double price;

    public BaseRobot(String name, String kind, int kilograms, double price){
        setName(name);
        setKind(kind);
        this.kilograms = kilograms;
        setPrice(price);
    }

    private int eatKgIncrease;

    protected void setEatKgIncrease(int eatKgIncrease) {
        this.eatKgIncrease = eatKgIncrease;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setKind(String kind) {
        if(kind == null || kind.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void eating() {
        this.kilograms += this.eatKgIncrease;
    }
}
