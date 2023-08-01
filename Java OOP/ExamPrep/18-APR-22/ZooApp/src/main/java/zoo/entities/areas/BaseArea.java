package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseArea implements Area{

    private String name;

    private int capacity;

    private Collection<Food> foods;

    private Collection<Animal> animals;


    public BaseArea(String name, int capacity){
        setName(name);
        setCapacity(capacity);
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(foods);
    }

    @Override
    public int sumCalories() {
        int totalCalories = 0;
        for(Food food : foods){
            totalCalories += food.getCalories();
        }
        return totalCalories;
    }

    @Override
    public void addAnimal(Animal animal) {
        if(animals.size() >= capacity){
            throw new IllegalStateException(ExceptionMessages
                    .NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for(Animal animal : animals){
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s (%s):",
                        name, getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Animals: " );
        List<String> animalNames = new ArrayList<>();
        animals.forEach(animal -> animalNames.add(animal.getName()));
        if(animalNames.size() > 0){
            output.append(String.join(" ", animalNames));
        }else {
            output.append("none");
        }
        output.append(System.lineSeparator())
                .append(String.format("Foods: %d", foods.size()))
                .append(System.lineSeparator())
                .append(String.format("Calories: %d", sumCalories()));
        return output.toString().trim();
    }
}
