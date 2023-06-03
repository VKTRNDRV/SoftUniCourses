package rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species){
        this.setName(name);
        this.setSpecies(species);
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = false;
    }

    @Override
    public String toString(){
        return String.format("Rabbit (%s): %s", this.getSpecies(), this.getName());
    }
}
