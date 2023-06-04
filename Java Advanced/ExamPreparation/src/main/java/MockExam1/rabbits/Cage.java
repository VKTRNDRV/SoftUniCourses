package MockExam1.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity){
        this.setName(name);
        this.setCapacity(capacity);
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Rabbit rabbit){
        if(this.data.size() < this.capacity){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){
        for (int i = 0; i < this.data.size(); i++) {
            if(this.data.get(i).getName().equals(name)){
                this.data.remove(i);
                return true;
            }
        }

        return false;
    }

    public void removeSpecies(String species){
        for (int i = this.data.size() - 1; i >= 0; i--) {
            if(this.data.get(i).getSpecies().equals(species)){
                this.data.remove(i);
            }
        }
    }

    //FIXME SHOULD THIS BE RETURNING NULL IF NO RABBIT IS FOUND
    public Rabbit sellRabbit(String name){
        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable();
                return rabbit;
            }
        }

        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable();
                rabbits.add(rabbit);
            }
        }

        return rabbits;
    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("Rabbits available at %s:%n", this.getName()));
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable())
                output.append(rabbit).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
