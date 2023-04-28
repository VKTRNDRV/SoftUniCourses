import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = sc.nextLine().trim();
        System.out.println();

        Properties dbCredsProps = new Properties();
        dbCredsProps.setProperty("user", user);
        dbCredsProps.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", dbCredsProps);

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees\n" +
                "JOIN departments ON employees.department_id = departments.department_id\n" +
                "WHERE salary > ?\n" +
                "ORDER BY salary DESC");

        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("first_name")
                    + " " + rs.getString("last_name")
                    + " // " + rs.getString("job_title")
                    + " // " + rs.getString("department_id")
                    + " // " + rs.getString("salary"));
        }
        connection.close();
    }
}