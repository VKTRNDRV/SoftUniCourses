import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {
    static String username;
    static String password;
    static String url;
    static Connection connection;
    static final String chooseExerciseNum =
            "==================================================================================\n" +
            "Input corresponding number for exercise or END to end program:\n" +
            "2. Get Villains’ Names\n" +
            "3. Get Minion Names\n" +
            "4. Add Minion\n" +
            "5. Change Town Names Casing\n" +
            "6. *Remove Villain\n" +
            "7. Print All Minion Names\n" +
            "8. Increase Minions Age\n" +
            "9. Increase Age Stored Procedure";

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Utils.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Utils.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Utils.url = url;
    }

    static Connection getSqlConnection() throws SQLException {
        if(connection == null) {
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            connection = DriverManager.getConnection(url, properties);
        }
        return connection;
    }
}
