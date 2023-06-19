import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncreaseAgeStoredProcedure {

    private static final String CALL_PROCEDURE_AGE_INCREMENT_BY_ID_SYNTAX =
            "call usp_get_older(?);";

    private static final String GET_MINION_NAME_AGE_BY_ID_SYNTAX =
            "select name, age\n" +
            "from minions\n" +
            "where id = ?;";

    private static final String MINION_NAME_AGE_FORMAT = "%s %d";

    public static void incrementMinionAge(int minionID) throws SQLException {
        PreparedStatement incrementAge = Utils
                .getSqlConnection()
                .prepareStatement(CALL_PROCEDURE_AGE_INCREMENT_BY_ID_SYNTAX);
        incrementAge.setInt(1, minionID);
        incrementAge.execute();
    }
    public static String getFormattedNameAndAge(int minionID) throws SQLException {
        PreparedStatement statement = Utils
                .getSqlConnection()
                .prepareStatement(GET_MINION_NAME_AGE_BY_ID_SYNTAX);
        statement.setInt(1, minionID);
        ResultSet minion = statement.executeQuery();
        minion.next();
        return String.format(
                MINION_NAME_AGE_FORMAT
                , minion.getString(1)
                , minion.getInt(2)
        );
    }
}
