package MockExam14.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        Egg strongestEgg = null;
        for (Egg egg : data) {
            if (strongestEgg == null || egg.getStrength() > strongestEgg.getStrength()) {
                strongestEgg = egg;
            }
        }
        return strongestEgg;
    }

    public Egg getEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder(material + " basket contains:\n");
        for (Egg egg : data) {
            result.append(egg.toString()).append("\n");
        }
        return result.toString().trim();
    }
}
