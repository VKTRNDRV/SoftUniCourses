import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMinion {
    static final String GET_TOWN_ID_SYNTAX =
            "select t.id\n" +
            "from towns t\n" +
            "where t.name = ?;";

    static final String GET_VILLAIN_ID_SYNTAX =
            "select v.id\n" +
            "from villains v\n" +
            "where v.name = ?;";

    static final String GET_MINION_ID_SYNTAX =
            "select m.id\n" +
            "from minions m\n" +
            "where m.name = ?;";

    static final String INSERT_TOWN_SYNTAX =
            "insert into towns (name)\n" +
            "values (?);";

    static final String INSERT_VILLAIN_SYNTAX =
            "insert into villains(name, evilness_factor)\n" +
            "value (?, 'evil');";

    static final String INSERT_MINION_SYNTAX =
            "insert into minions(name, age, town_id)\n" +
            "value (?, ?, ?);";

    static final String ASSIGN_VILLAIN_TO_MINION_SYNTAX =
            "insert into minions_villains(minion_id, villain_id)\n" +
            "value (?, ?);";

    public static boolean existsTownWithName(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getTownID = connection.prepareStatement(GET_TOWN_ID_SYNTAX);
        getTownID.setString(1, name);
        ResultSet resultSet = getTownID.executeQuery();
        return resultSet.next();
    }

    public static boolean existsVillainWithName(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getVillainID = connection.prepareStatement(GET_VILLAIN_ID_SYNTAX);
        getVillainID.setString(1, name);
        ResultSet resultSet = getVillainID.executeQuery();
        return resultSet.next();
    }

    public static int getTownIdByName(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getTownID = connection.prepareStatement(GET_TOWN_ID_SYNTAX);
        getTownID.setString(1, name);
        ResultSet resultSet = getTownID.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int getVillainIdByName(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getVillainID = connection.prepareStatement(GET_VILLAIN_ID_SYNTAX);
        getVillainID.setString(1, name);
        ResultSet resultSet = getVillainID.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int getMinionIdByName(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getMinionID = connection.prepareStatement(GET_MINION_ID_SYNTAX);
        getMinionID.setString(1, name);
        ResultSet resultSet = getMinionID.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static void addTown(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement insertTown = connection.prepareStatement(INSERT_TOWN_SYNTAX);
        insertTown.setString(1, name);
        insertTown.executeUpdate();
    }

    public static void addVillain(String name) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN_SYNTAX);
        insertVillain.setString(1, name);
        insertVillain.executeUpdate();
    }

    public static void addMinion(String name, int age, int townID) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement insertMinion = connection.prepareStatement(INSERT_MINION_SYNTAX);
        insertMinion.setString(1, name);
        insertMinion.setInt(2, age);
        insertMinion.setInt(3, townID);
        insertMinion.executeUpdate();
    }

    public static void setVillainOfMinion(int minionID, int villainID) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement setVillainOfMinion = connection.prepareStatement(ASSIGN_VILLAIN_TO_MINION_SYNTAX);
        setVillainOfMinion.setInt(1, minionID);
        setVillainOfMinion.setInt(2, villainID);
        setVillainOfMinion.executeUpdate();
    }
}
