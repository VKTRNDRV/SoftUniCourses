import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVilliansNames {
    private static final String QUERY_SYNTAX =
            "select v.name, count(distinct mv.minion_id) as `minions_count`\n" +
            "from villains v\n" +
            "    join minions_villains mv on v.id = mv.villain_id\n" +
            "group by v.id\n" +
            "having `minions_count` > 15\n" +
            "order by `minions_count` desc;";

    private static final String ROW_PRINT_FORMAT = "%s - %d";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_NAME_COUNT = "minions_count";

    public static ResultSet getResultSet() throws SQLException {
        Connection connection = Utils.getSqlConnection();
        PreparedStatement statement = connection.prepareStatement(GetVilliansNames.QUERY_SYNTAX);
        return statement.executeQuery();
    }

    public static void printToConsole(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            final String name = resultSet.getString(COLUMN_LABEL_NAME);
            final int minionsCount = resultSet.getInt(COLUMN_NAME_COUNT);
            System.out.printf(ROW_PRINT_FORMAT, name, minionsCount);
            System.out.println();
        }
    }
}
