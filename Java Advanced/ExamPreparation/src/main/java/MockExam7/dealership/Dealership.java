package MockExam7.dealership;

import java.util.ArrayList;
import java.util.Collection;

public class Dealership {
    public String name;
    public int capacity;
    public Collection<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int latestYear = 0;
        for (Car car : data) {
            if (car.getYear() > latestYear) {
                latestCar = car;
                latestYear = car.getYear();
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("The cars in a car dealership ").append(name).append(":\n");
        for (Car car : data) {
            statistics.append(car.toString()).append("\n");
        }
        return statistics.toString().trim();
    }
}
