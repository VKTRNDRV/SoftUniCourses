package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name){
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParent(Parent parent){
        this.parents.add(parent);
    }

    public void addChild(Child child){
        this.children.add(child);
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s%n", this.name));
        output.append(String.format("Company:%n"));
        if(this.company != null) {
            output.append(String.format("%s%n", this.company.toString()));
        }
        output.append(String.format("Car:%n"));
        if(this.car != null) {
            output.append(String.format("%s%n", this.car.toString()));
        }
        output.append(String.format("Pokemon:%n"));
        for(Pokemon pokemon : pokemons){
            output.append(String.format("%s%n", pokemon.toString()));
        }
        output.append(String.format("Parents:%n"));
        for(Parent parent : parents){
            output.append(String.format("%s%n", parent.toString()));
        }
        output.append(String.format("Children:%n"));
        for(Child child : children){
            output.append(String.format("%s%n", child.toString()));
        }

        return output.toString();
    }
}
