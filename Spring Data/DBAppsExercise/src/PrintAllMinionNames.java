import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    public static final String GET_ALL_MINION_NAMES_SYNTAX =
            "select name from minions;";

    public static List<String> getNamesInSpecialOrder() throws SQLException {
        ResultSet namesDefaultOrder = Utils
                .getSqlConnection()
                .prepareStatement(GET_ALL_MINION_NAMES_SYNTAX)
                .executeQuery();

        // add name strings to an arraydeque
        ArrayDeque<String> defaultOrderNames = new ArrayDeque<>();
        while (namesDefaultOrder.next()){
            defaultOrderNames.add(namesDefaultOrder.getString(1));
        }

        // add all names to list in special order
        int namesCount = defaultOrderNames.size();
        List<String> specialOrderNames = new ArrayList<>();
        if(namesCount % 2 == 0){
            while (!defaultOrderNames.isEmpty()){
                specialOrderNames.add(defaultOrderNames.removeFirst());
                specialOrderNames.add(defaultOrderNames.removeLast());
            }
        }else {
            while (defaultOrderNames.size() > 1){
                specialOrderNames.add(defaultOrderNames.removeFirst());
                specialOrderNames.add(defaultOrderNames.removeLast());
            }
            specialOrderNames.add(defaultOrderNames.removeFirst());
        }

        return specialOrderNames;
    }
}
