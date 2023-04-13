package CarShop;

import java.io.Serializable;

public class CarImpl implements Car, Serializable {
    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced){
        setModel(model);
        setColor(color);
        setHorsePower(horsePower);
        setCountryProduced(countryProduced);
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    private void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString(){
        return String.format("This is %s produced in %s and have %d tires",
                this.getModel(),
                this.countryProduced(),
                TIRES
        );
    }
}
