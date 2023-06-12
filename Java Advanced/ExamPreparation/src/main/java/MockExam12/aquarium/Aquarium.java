package MockExam12.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (!containsFishWithName(fish.getName()) && hasEnoughSpace()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Aquarium: ").append(name).append(" ^ Size: ").append(size).append("\n");
        for (Fish fish : fishInPool) {
            reportBuilder.append(fish.toString()).append("\n");
        }
        return reportBuilder.toString().trim();
    }

    private boolean containsFishWithName(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasEnoughSpace() {
        return fishInPool.size() < capacity;
    }
}
