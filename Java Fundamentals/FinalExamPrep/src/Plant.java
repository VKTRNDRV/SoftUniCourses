import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plant {

    public static List<Plant> plantsList = new ArrayList<>();
    public String name;
    public List<Integer> ratingsList;
    public int rarity;

    public Plant(String name, int rarity){
        this.name = name;
        this.ratingsList = new ArrayList<>();
        this.rarity = rarity;
    }

    public static boolean isPlantPresent(String name){
        for(Plant plant : plantsList){
            if(plant.name.equals(name)){
                return true;
            }
        }

        return false;
    }

    public static Plant getPlantByName(String name){
        for(Plant plant : plantsList){
            if(plant.name.equals(name)){
                return plant;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfInitialPlants = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numOfInitialPlants; i++) {
            String[] plantArr = scanner.nextLine().split("<->");
            String plantName = plantArr[0];
            int plantRarity = Integer.parseInt(plantArr[1]);

            if(isPlantPresent(plantName)) {
                for(Plant plant : plantsList){
                    if(plant.name.equals(plantName)){
                        plant.rarity = plantRarity;
                    }
                }
            }else{
                Plant plant = new Plant(plantName, plantRarity);
                plantsList.add(plant);
            }
        }

        while (true){
            String[] commandArr = scanner.nextLine().split("((: )|( - ))");
            if(commandArr[0].equals("Exhibition")){break;}
            String command = commandArr[0];
            String plantName = commandArr[1];

            switch (command){
                case "Rate":
                    int ratingToAdd = Integer.parseInt(commandArr[2]);
                    if(isPlantPresent(plantName)){
                        Plant plant = getPlantByName(plantName);
                        plant.ratingsList.add(ratingToAdd);

                    }else{
                        System.out.println("error");
                    }
                    break;

                case "Update":
                    int rarityNew = Integer.parseInt(commandArr[2]);
                    if(isPlantPresent(plantName)){
                        Plant plant = getPlantByName(plantName);
                        plant.rarity = rarityNew;
                    }else{
                        System.out.println("error");
                    }
                    break;

                case "Reset":
                    if(isPlantPresent(plantName)){
                        Plant plant = getPlantByName(plantName);
                        plant.ratingsList.clear();
                    }else{
                        System.out.println("error");
                    }
                    break;
            }
        }

        System.out.println("Plants for the exhibition:");
        for(Plant plant : plantsList){
            String plantName = plant.name;
            int plantRarity = plant.rarity;
            List<Integer> plantRatingsList = plant.ratingsList;
            double avgRating = 0;
            if(plantRatingsList.size() > 0){
                for(int rating : plantRatingsList){
                    avgRating += rating;
                }
                avgRating /= plantRatingsList.size();
            }

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, plantRarity, avgRating);
        }
    }
}
