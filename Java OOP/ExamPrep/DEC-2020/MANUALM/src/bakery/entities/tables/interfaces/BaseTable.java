package bakery.entities.tables.interfaces;

import bakery.common.ExceptionMessages;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table{

    private Collection<BakedFood> foodOrders;

    private Collection<Drink> drinkOrders;

    private int tableNumber;

    private int capacity;

    private int numberOfPeople;

    private double pricePerPerson;

    private boolean isReserved;

    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson){
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.price = 0;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }


    private void setCapacity(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException(
                    ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople){
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(
                    ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        if(numberOfPeople > capacity){
            throw new IllegalArgumentException(
                    ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.isReserved = true;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0;
        for(BakedFood food : foodOrders){
            bill += food.getPrice();
        }
        for(Drink drink : drinkOrders){
            bill += drink.getPrice();
        }
        bill += pricePerPerson*numberOfPeople;
        price = bill;
        return price;
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        isReserved = false;
        numberOfPeople = 0;
        price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %d\n" +
                "Type: %s\n" +
                "Capacity: %d\n" +
                "Price per Person: %.2f",
                tableNumber,
                this.getClass().getSimpleName(),
                capacity, pricePerPerson);
    }
}
