package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> trainers = new ArrayList<>();
        while (true){
            String[] data = scanner.nextLine().split("\\s+");
            if(data[0].equals("Tournament")){break;}
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Trainer trainer = null;
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            for(Trainer tr : trainers){
                if(tr.getName().equals(trainerName)){
                    trainer = tr;
                    break;
                }
            }
            if(trainer == null){
                trainer = new Trainer(trainerName);
                trainers.add(trainer);
            }

            trainer.addPokemon(pokemon);
        }

        while (true){
            String element = scanner.nextLine();
            if(element.equals("End")){break;}

            for (int i = 0; i < trainers.size(); i++) {
                Trainer trainer = trainers.get(i);
                if(trainer.hasPokemonOfElement(element)){
                    trainer.addBadge();
                }else{
                    trainer.damagePokemons();
                }
            }
        }

        Collections.sort(trainers, (t1, t2) -> Integer.compare(t2.getBadgesCount(), t1.getBadgesCount()));

        for(Trainer trainer : trainers){
            System.out.printf("%s %d %d%n",
                    trainer.getName(),
                    trainer.getBadgesCount(),
                    trainer.getPokemons().size());
        }
    }
}
