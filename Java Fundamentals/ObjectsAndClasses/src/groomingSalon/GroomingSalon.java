package groomingSalon;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;


    public GroomingSalon(int capacity, List<Pet> data){
        this.capacity = capacity;
        this.data = data;
    }
    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for(Pet currentPet : this.data){
            if(name.equals(currentPet.getName())){
                this.data.remove(currentPet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for(Pet currentPet : this.data){
            if(currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)){
                return currentPet;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        String output = String.format(" The grooming salon has the following clients:%n");
        for (Pet currentPet : this.data) {
            output = output.concat(String.format("%s %s%n", currentPet.getName(), currentPet.getOwner()));
        }
        return output;
    }
}
