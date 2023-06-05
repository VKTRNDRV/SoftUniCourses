package MockExam3.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayers = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                removedPlayers.add(player);
            }
        }
        roster.removeAll(removedPlayers);
        return removedPlayers.toArray(new Player[0]);
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        result.append("Players in the guild: ").append(name).append(":\n");
        for (Player player : roster) {
            result.append(player).append("\n");
        }
        return result.toString();
    }
}
