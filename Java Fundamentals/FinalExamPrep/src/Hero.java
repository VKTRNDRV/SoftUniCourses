import java.util.*;

class Hero {
    String name;
    int hp;
    int mp;

    public Hero(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public void castSpell(int mpNeeded, String spellName) {
        if (mpNeeded > mp) {
            System.out.println(name + " does not have enough MP to cast " + spellName + "!");
        } else {
            mp -= mpNeeded;
            System.out.println(name + " has successfully cast " + spellName + " and now has " + mp + " MP!");
        }
    }

    public void takeDamage(int damage, String attacker) {
        hp -= damage;
        if (hp > 0) {
            System.out.println(name + " was hit for " + damage + " HP by " + attacker + " and now has " + hp + " HP left!");
        } else {
            System.out.println(name + " has been killed by " + attacker + "!");
        }
    }

    public void recharge(int amount) {
        int mpRecovered = Math.min(amount, 200 - mp);
        mp += mpRecovered;
        System.out.println(name + " recharged for " + mpRecovered + " MP!");
    }

    public void heal(int amount) {
        int hpRecovered = Math.min(amount, 100 - hp);
        hp += hpRecovered;
        System.out.println(name + " healed for " + hpRecovered + " HP!");
    }

    public void printStatus() {
        System.out.println(name);
        System.out.println("  HP: " + hp);
        System.out.println("  MP: " + mp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Hero> heroes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] heroData = scanner.nextLine().split("\\s+");
            Hero hero = new Hero(heroData[0], Integer.parseInt(heroData[1]), Integer.parseInt(heroData[2]));
            heroes.add(hero);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");

            Hero currentHero = heroes.stream().filter(hero -> hero.name.equals(tokens[1])).findFirst().orElse(null);

            if (currentHero != null) {
                switch (tokens[0]) {
                    case "CastSpell":
                        int mpNeeded = Integer.parseInt(tokens[2]);
                        String spellName = tokens[3];
                        currentHero.castSpell(mpNeeded, spellName);
                        break;

                    case "TakeDamage":
                        int damage = Integer.parseInt(tokens[2]);
                        String attacker = tokens[3];
                        currentHero.takeDamage(damage, attacker);
                        if (currentHero.hp <= 0) {
                            heroes.remove(currentHero);
                        }
                        break;

                    case "Recharge":
                        int amount = Integer.parseInt(tokens[2]);
                        currentHero.recharge(amount);
                        break;

                    case "Heal":
                        amount = Integer.parseInt(tokens[2]);
                        currentHero.heal(amount);
                        break;

                    default:
                        break;
                }
            }

            input = scanner.nextLine();
        }

        for (Hero hero : heroes) {
            hero.printStatus();
        }
    }
}
