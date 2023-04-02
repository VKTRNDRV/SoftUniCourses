import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> heroesMap = new LinkedHashMap<>();
        while (true){
            String[] commandArr = scanner.nextLine().split(" ");
            if(commandArr[0].equals("End")){break;}
            String command = commandArr[0];
            String heroName = commandArr[1];
            switch (command){
                case "Enroll":
                    if(!heroesMap.containsKey(heroName)){
                        heroesMap.put(heroName, new ArrayList<>());
                    }else{
                        System.out.printf("%s is already enrolled.%n", heroName);
                    }
                    break;

                case "Learn":
                    String spellNameLearn = commandArr[2];
                    if(heroesMap.containsKey(heroName)){
                        if(!heroesMap.get(heroName).contains(spellNameLearn)){
                            heroesMap.get(heroName).add(spellNameLearn);
                        }else{
                            System.out.printf("%s has already learnt %s.%n", heroName, spellNameLearn);
                        }
                    }else{
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }
                    break;

                case "Unlearn":
                    String spellNameRemove = commandArr[2];
                    if(heroesMap.containsKey(heroName)){
                        if(heroesMap.get(heroName).contains(spellNameRemove)){
                            heroesMap.get(heroName).remove(spellNameRemove);
                        }else{
                            System.out.printf("%s doesn't know %s.%n", heroName, spellNameRemove);
                        }
                    }else{
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }
                    break;
            }
        }

        System.out.println("Heroes:");
        for(Map.Entry<String, List<String>> heroEntry : heroesMap.entrySet()){
            String heroName = heroEntry.getKey();
            List<String> heroSpellsList = heroEntry.getValue();
            System.out.printf("== %s: ", heroName);
            System.out.println(String.join(", ", heroSpellsList));
        }
    }
}
