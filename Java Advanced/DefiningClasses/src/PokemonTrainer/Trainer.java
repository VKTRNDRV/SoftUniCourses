package PokemonTrainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trainer {
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon){
        this.pokemons.remove(pokemon);
    }

    public void addBadge(){
        this.badgesCount++;
    }

    public boolean hasPokemonOfElement(String element){
        for(Pokemon pokemon : pokemons){
            if(pokemon.getElement().equals(element)){
                return true;
            }
        }

        return false;
    }

    public void damagePokemons(){
        for (int i = 0; i < this.pokemons.size(); i++) {
            Pokemon pokemon = this.pokemons.get(i);
            pokemon.reduceHealth();
            if(pokemon.isDead()){
                this.pokemons.remove(pokemon);
                i--;
            }
        }
    }
}
