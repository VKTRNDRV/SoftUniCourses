package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.*;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;

    private Collection<Area> areas;

    public ControllerImpl(){
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area = null;
        if(areaType.equals("LandArea")){
            area = new LandArea(areaName);
        }else if(areaType.equals("WaterArea")){
            area = new WaterArea(areaName);
        }else {
            throw new NullPointerException(ExceptionMessages
                    .INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food = null;
        if(foodType.equals("Vegetable")){
            food = new Vegetable();
        }else if(foodType.equals("Meat")){
            food = new Meat();
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if(food == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages
                    .NO_FOOD_FOUND, foodType));
        }
        Area area = getAreaByName(areaName);
        foodRepository.remove(food);
        area.addFood(food);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    private Area getAreaByName(String name){
        return areas.stream().filter(area -> area
                .getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal = null;
        Area area = getAreaByName(areaName);
        if(animalType.equals("TerrestrialAnimal")){
            animal = new TerrestrialAnimal(animalName, kind, price);
            if(!area.getClass().equals(LandArea.class)){
                return ConstantMessages.AREA_NOT_SUITABLE;
            }
        }else if(animalType.equals("AquaticAnimal")){
            animal = new AquaticAnimal(animalName, kind, price);
            if(!area.getClass().equals(WaterArea.class)){
                return ConstantMessages.AREA_NOT_SUITABLE;
            }
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_ANIMAL_TYPE);
        }
        try {
            area.addAnimal(animal);
        }catch (IllegalStateException e){
            return e.getMessage();
        }
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = getAreaByName(areaName);
        area.feed();
        return String.format(ConstantMessages
                .ANIMALS_FED, area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = getAreaByName(areaName);
        double totalKg = 0;
        for(Animal animal : area.getAnimals()){
            totalKg += animal.getKg();
        }
        return String.format(ConstantMessages
                .KILOGRAMS_AREA, areaName, totalKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        areas.forEach(area -> output.append(area.getInfo())
                .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
