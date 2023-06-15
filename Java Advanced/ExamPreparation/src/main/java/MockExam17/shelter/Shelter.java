package MockExam17.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal oldestAnimal = null;
        int maxAge = 0;
        for (Animal animal : data) {
            if (animal.getAge() > maxAge) {
                maxAge = animal.getAge();
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder("The shelter has the following animals:\n");
        for (Animal animal : data) {
            statistics.append(animal.getName())
                    .append(" ")
                    .append(animal.getCaretaker())
                    .append("\n");
        }
        return statistics.toString().trim();
    }
}
