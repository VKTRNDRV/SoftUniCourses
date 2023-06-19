import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveVillain {
    private static final String CHECK_IF_VILLAIN_EXISTS_SYNTAX =
            "select name\n" +
            "from villains\n" +
            "where id = ?;";

    private static final String GET_VILLAIN_NAME_BY_ID_SYNTAX =
            "select name\n" +
            "from villains\n" +
            "where id = ?;";

    private static final String GET_COUNT_OF_MINIONS_BY_VILLAIN_SYNTAX =
            "select count(minion_id)\n" +
            "from minions_villains\n" +
            "where villain_id = ?;";

    private static final String DELETE_VILLAIN_SYNTAX =
            "delete\n" +
            "from villains\n" +
            "where id = ?;";

    private static final String RELEASE_MINIONS_SYNTAX =
            "delete\n" +
            "from minions_villains\n" +
            "where villain_id = ?;";

    public static boolean existsVillainWithID(int id) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement check = connection.prepareStatement(CHECK_IF_VILLAIN_EXISTS_SYNTAX);
        check.setInt(1, id);
        ResultSet resultSet = check.executeQuery();
        return resultSet.next();
    }

    public static String getVillainName(int id) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement check = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID_SYNTAX);
        check.setInt(1, id);
        ResultSet resultSet = check.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }

    public static int getCountOfMinions(int villainID) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getCount = connection.prepareStatement(GET_COUNT_OF_MINIONS_BY_VILLAIN_SYNTAX);
        getCount.setInt(1, villainID);
        ResultSet resultSet = getCount.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static void deleteVillain(int villainID) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAIN_SYNTAX);
        deleteVillain.setInt(1, villainID);
        deleteVillain.executeUpdate();
    }

    public static void releaseMinions(int villainID) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement releaseMinions = connection.prepareStatement(RELEASE_MINIONS_SYNTAX);
        releaseMinions.setInt(1, villainID);
        releaseMinions.executeUpdate();
    }
}
