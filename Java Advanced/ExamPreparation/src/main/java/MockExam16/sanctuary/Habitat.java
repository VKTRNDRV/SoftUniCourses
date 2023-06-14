package MockExam16.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                data.remove(elephant);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        Elephant oldestElephant = null;
        for (Elephant elephant : data) {
            if (oldestElephant == null || elephant.getAge() > oldestElephant.getAge()) {
                oldestElephant = elephant;
            }
        }
        return oldestElephant;
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Saved elephants in the park:\n");
        for (Elephant elephant : data) {
            report.append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom()).append("\n");
        }
        return report.toString().trim();
    }
}






