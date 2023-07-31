package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class BaseHouse implements House{

    private String name;

    private int capacity;

    private Collection<Toy> toys;

    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int totalSoftness = 0;
        for(Toy toy : toys){
            totalSoftness += toy.getSoftness();
        }
        return totalSoftness;
    }

    @Override
    public void addCat(Cat cat) {
        if(cats.size() >= capacity){
            throw new IllegalStateException(ConstantMessages
                    .NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        String name = cat.getName();
        for(Cat c : cats){
            if(c.getName().equals(name)){
                cats.remove(c);
            }
        }
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s %s:\nCats: ",
                name, this.getClass().getSimpleName()));
        if(cats.size() == 0){
            output.append("none");
        }else {
            List<String> catNames = new ArrayList<>();
            cats.forEach(cat -> catNames.add(cat.getName()));
            output.append(String.join(" ", catNames));
        }
        output.append(System.lineSeparator());
        output.append(String.format("Toys: %d Softness: %d",
                toys.size(), sumSoftness()));
        return output.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
