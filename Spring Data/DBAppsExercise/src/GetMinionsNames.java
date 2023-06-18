import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMinionsNames {
    private static final String GET_MINIONS_SYNTAX =
                "select distinct m.name, m.age\n" +
                "from minions m\n" +
                "    join minions_villains mv on m.id = mv.minion_id\n" +
                "where mv.villain_id = ?;";
    private static final int MINION_NAME_COLUMN_INDEX = 1;
    private static final int MINION_AGE_COLUMN_INDEX = 2;

    private static final String GET_VILLAIN_NAME_SYNTAX =
            "select name\n" +
            "from villains\n" +
            "where id = ?;";

    private static final int VILLAIN_NAME_COLUMN_INDEX = 1;
    private static final String ROW_PRINT_FORMAT = "%d. %s %d";

    public static boolean existsVillainWithID(int id) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getVillainID = connection.prepareStatement(GET_VILLAIN_NAME_SYNTAX);
        getVillainID.setInt(1, id);
        ResultSet resultSet = getVillainID.executeQuery();
        return resultSet.next();
    }

    public static String getVillainName(int id) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getVillainID = connection.prepareStatement(GET_VILLAIN_NAME_SYNTAX);
        getVillainID.setInt(1, id);
        ResultSet resultSet = getVillainID.executeQuery();
        resultSet.next();
        return resultSet.getString(VILLAIN_NAME_COLUMN_INDEX);
    }


    public static ResultSet getMinions(int villainID) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getMinions = connection.prepareStatement(GET_MINIONS_SYNTAX);
        getMinions.setInt(1, villainID);
        return getMinions.executeQuery();
    }
    public static void printToConsole(String villainName, ResultSet resultSet) throws SQLException {
        System.out.printf("Villain: %s\n", villainName);
        int counter = 1;
        String name;
        int age;
        while (resultSet.next()){
            name = resultSet.getString(MINION_NAME_COLUMN_INDEX);
            age = resultSet.getInt(MINION_AGE_COLUMN_INDEX);
            System.out.printf(ROW_PRINT_FORMAT, counter, name, age);
            System.out.println();
            counter++;
        }
    }
}
