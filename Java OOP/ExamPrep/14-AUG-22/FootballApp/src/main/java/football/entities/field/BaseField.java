package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseField implements Field{

    private String name;

    private int capacity;

    private Collection<Supplement> supplements;

    private Collection<Player> players;


    public BaseField(String name, int capacity){
        setName(name);
        setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }


    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumEnergy() {
        int totalSum = 0;
        for(Supplement supplement : supplements){
            totalSum += supplement.getEnergy();
        }
        return totalSum;
    }

    @Override
    public void addPlayer(Player player) {
        if(players.size() >= capacity){
            throw new IllegalStateException(ConstantMessages
                    .NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s (%s):",
                        name, getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Player: ");
        List<String> playerNames = new ArrayList<>();
        players.forEach(p -> playerNames.add(p.getName()));
        if(playerNames.size() == 0){
            output.append("none");
        }else {
            output.append(String.join(" ", playerNames));
        }
        output.append(System.lineSeparator())
                .append("Supplement: ")
                .append(supplements.size())
                .append(System.lineSeparator())
                .append("Energy: ")
                .append(sumEnergy());

        return output.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public String getName() {
        return name;
    }
}
