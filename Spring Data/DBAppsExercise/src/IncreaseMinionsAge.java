import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncreaseMinionsAge {

    private static final String INCREMENT_MINION_AGE_BY_ID_SYNTAX =
            "update minions\n" +
            "set age = age + 1\n" +
            "where id = ?;";

    private static final String SET_MINION_NAME_TO_LOWERCASE_BY_ID_SYNTAX =
            "update minions\n" +
            "set name = lower(name)\n" +
            "where id = ?;";

    private static final String GET_ALL_MINIONS_NAME_AGE_SYNTAX =
            "select name, age from minions;";

    private static final String MINION_INFO_FORMAT = "%s %d";

    public static void incrementMinionAge(int id) throws SQLException {
        PreparedStatement incrementAge =  Utils.getSqlConnection()
                .prepareStatement(INCREMENT_MINION_AGE_BY_ID_SYNTAX);
        incrementAge.setInt(1, id);
        incrementAge.executeUpdate();
    }

    public static void setMinionNameToLowercase(int id) throws SQLException {
        PreparedStatement setNameToLowercase =  Utils.getSqlConnection()
                .prepareStatement(SET_MINION_NAME_TO_LOWERCASE_BY_ID_SYNTAX);
        setNameToLowercase.setInt(1, id);
        setNameToLowercase.executeUpdate();
    }

    public static List<String> getMinionsNamesAges() throws SQLException {
        ResultSet minionsRS = Utils
                .getSqlConnection()
                .prepareStatement(GET_ALL_MINIONS_NAME_AGE_SYNTAX)
                .executeQuery();
        List<String> minionsNamesAges = new ArrayList<>();
        while (minionsRS.next()){
            minionsNamesAges.add(String.format(MINION_INFO_FORMAT
                    , minionsRS.getString(1)
                    , minionsRS.getInt(2)));
        }
        return minionsNamesAges;
    }
}
