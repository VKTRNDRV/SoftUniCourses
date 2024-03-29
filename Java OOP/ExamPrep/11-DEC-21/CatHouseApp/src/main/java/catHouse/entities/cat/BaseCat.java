package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;

public abstract class BaseCat implements Cat{

    private String name;

    private String breed;

    private int kilograms;

    private double price;

    public BaseCat(String name, String breed, double price){
        setName(name);
        setBreed(breed);
        setPrice(price);
    }


    private int eatingKiloIncrease;

    protected void setEatingKiloIncrease(int eatingKiloIncrease){
        this.eatingKiloIncrease = eatingKiloIncrease;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setBreed(String breed) {
        if(breed == null || breed.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    protected void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
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
        this.kilograms += this.eatingKiloIncrease;
    }
}
