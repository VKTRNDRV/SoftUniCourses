import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
        int maxHealth = 100;
        int maxMana = 200;
        int numOfHeroes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfHeroes; i++) {
            String[] heroArr = scanner.nextLine().split(" ");
            String name = heroArr[0];
            int health = Integer.parseInt(heroArr[1]);
            int mana = Integer.parseInt(heroArr[2]);
            heroesMap.put(name, new ArrayList<>());
            heroesMap.get(name).add(health);
            heroesMap.get(name).add(mana);
        }

        while (true){
            String[] commandArr = scanner.nextLine().split(" - ");
            if(commandArr[0].equals("End")){break;}
            String command = commandArr[0];
            String heroName = commandArr[1];
            int heroHealth = heroesMap.get(heroName).get(0);
            int heroMana = heroesMap.get(heroName).get(1);
            switch (command){
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(commandArr[2]);
                    String spellName = commandArr[3];
                    if(manaNeeded <= heroMana){
                        heroMana -= manaNeeded;
                        heroesMap.get(heroName).set(1, heroMana);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                , heroName, spellName, heroMana);
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;

                case "TakeDamage":
                    int damageTaken = Integer.parseInt(commandArr[2]);
                    String attacker = commandArr[3];
                    if(damageTaken < heroHealth){
                        heroHealth -= damageTaken;
                        heroesMap.get(heroName).set(0, heroHealth);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damageTaken, attacker, heroHealth);
                    }else{
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;

                case "Recharge":
                    int rechargeAmount = Integer.parseInt(commandArr[2]);
                    if(heroMana + rechargeAmount > maxMana){
                        rechargeAmount = maxMana - heroMana;
                        heroMana = maxMana;
                    }else{
                        heroMana += rechargeAmount;
                    }
                    heroesMap.get(heroName).set(1, heroMana);
                    System.out.printf("%s recharged for %d MP!%n", heroName, rechargeAmount);
                    break;

                case "Heal":
                    int healAmount = Integer.parseInt(commandArr[2]);
                    if(heroHealth + healAmount > maxHealth){
                        healAmount = maxHealth - heroHealth;
                        heroHealth = maxHealth;
                    }else{
                        heroHealth += healAmount;
                    }
                    heroesMap.get(heroName).set(0, heroHealth);
                    System.out.printf("%s healed for %d HP!%n", heroName, healAmount);
                    break;
            }
        }

        for(Map.Entry<String, List<Integer>> heroEntry : heroesMap.entrySet()){
            String name = heroEntry.getKey();
            int health = heroEntry.getValue().get(0);
            int mana = heroEntry.getValue().get(1);
            System.out.printf("%s%n", name);
            System.out.printf("  HP: %d%n", health);
            System.out.printf("  MP: %d%n", mana);
        }
    }
}
