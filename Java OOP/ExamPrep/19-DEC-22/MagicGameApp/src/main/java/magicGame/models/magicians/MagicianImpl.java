package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician{

    private String username;

    private int health;

    private int protection;

    private boolean isAlive;

    private Magic magic;


    public MagicianImpl(String username, int health, int protection, Magic magic){
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        updateIsAlive();
    }


    protected void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    protected void setHealth(int health) {
        if(health < 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if(protection < 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    protected void setMagic(Magic magic) {
        if(magic == null){
            throw new NullPointerException(ExceptionMessages
                    .INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        updateIsAlive();
        return isAlive;
    }

    private void updateIsAlive() {
        this.isAlive = (health > 0);
    }

//    @Override
//    public void takeDamage(int points) {
//        while(protection > 0 && points > 0){
//            protection--;
//            points--;
//        }
//        while (health > 0 && points > 0){
//            health--;
//            points--;
//        }
//        if(health <= 0){
//            updateIsAlive();
//        }
//    }

    @Override
    public void takeDamage(int points) {
        this.protection -= points;
        if (this.protection < 0){
            health += this.protection;
            //this.protection = 0;
        }
        if (health <= 0){
            isAlive = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int hp = health;
        if(hp < 0){
            hp = 0;
        }
        int prot = protection;
        if(prot < 0){
            prot = 0;
        }
        output.append(String.format("%s: %s",
                        this.getClass().getSimpleName(), username))
                .append(System.lineSeparator())
                .append(String.format("Health: %d", hp))
                .append(System.lineSeparator())
                .append(String.format("Protection: %d", prot))
                .append(System.lineSeparator())
                .append(String.format("Magic: %s", magic.getName()));
        return output.toString().trim();
    }
}
