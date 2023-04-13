package CarShop;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        setPrice(price);
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        unusualSymbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#.000000", unusualSymbols);
        String formattedPrice = df.format(this.getPrice());

        return super.toString() + String.format("%n%s sells for %s"
                , this.getModel()
                , formattedPrice
        );
    }
}
