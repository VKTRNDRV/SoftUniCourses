package CarShop;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        setMinRentDay(minRentDay);
        setPricePerDay(pricePerDay);
    }

    public Integer getMinRentDay() {
        return minRentDay;
    }

    public void setMinRentDay(Integer minRentDay) {
        this.minRentDay = minRentDay;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString(){
        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        unusualSymbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#.000000", unusualSymbols);
        String formattedPricePerDay = df.format(this.getPricePerDay());

        return super.toString() + String.format("%nMinimum rental period of %d days. Price per day %s"
                , this.getMinRentDay()
                , formattedPricePerDay
        );
    }
}
