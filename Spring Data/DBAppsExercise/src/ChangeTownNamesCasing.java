import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {
    private static final String GET_TOWN_NAMES_BY_COUNTRY_SYNTAX =
            "select name\n" +
            "from towns\n" +
            "where country = ?;";

    private static final String UPDATE_TOWN_NAME_TO_SYNTAX =
            "update towns\n" +
            "set name = ?\n" +
            "where name = ?;";

    public static boolean containsCountry(String country) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement containsCountry = connection.prepareStatement(GET_TOWN_NAMES_BY_COUNTRY_SYNTAX);
        containsCountry.setString(1, country);
        ResultSet townNames = containsCountry.executeQuery();
        return townNames.next();
    }

    public static List<String> getTownNamesByCountry(String country) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement getTownNamesByCountry = connection.prepareStatement(GET_TOWN_NAMES_BY_COUNTRY_SYNTAX);
        getTownNamesByCountry.setString(1, country);
        ResultSet towns = getTownNamesByCountry.executeQuery();
        List<String> names = new ArrayList<>();
        while (towns.next()){
            names.add(towns.getString(1));
        }
        return names;
    }

    public static void updateTownName(String townName) throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement updateName = connection.prepareStatement(UPDATE_TOWN_NAME_TO_SYNTAX);
        updateName.setString(1, townName.toUpperCase());
        updateName.setString(2, townName);
        updateName.executeUpdate();
    }
}
