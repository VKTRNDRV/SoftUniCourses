import entities.Employee;
import entities.Town;
import exercises.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(EXERCISE_NUMBER_PROMPT);
        String command = scanner.nextLine();
        while (!command.equals("END")){

            if(command.equals("2")){
                ChangeCasing.execute();
                System.out.println("Towns updated.");

            } else if (command.equals("3")) {
                System.out.println(EMPLOYEE_NAME_PROMPT);
                String name = scanner.nextLine().trim();
                System.out.println(
                        ContainsEmployee.execute(name)
                );
                
            } else if (command.equals("4")) {
                String[] firstNames = EmployeesWithSalaryOver50K.getFirstNames();
                for (String firstName : firstNames) {
                    System.out.println(firstName);
                }

            } else if (command.equals("5")) {
                String[] employeesInfo = EmployeesFromDepartment.getSortedEmployees();
                for(String info : employeesInfo){
                    System.out.println(info);
                }

            } else if (command.equals("6")) {
                System.out.println(EMPLOYEE_LAST_NAME_PROMPT);
                String lastName = scanner.nextLine();
                AddingNewAddressUpdatingEmployee.execute(lastName);

            } else if (command.equals("7")) {
                String[] results = AddressesWithEmployeeCount.getSortedInfo();
                for (String str : results){
                    System.out.println(str);
                }

            } else if (command.equals("8")) {
                System.out.println(EMPLOYEE_ID_PROMPT);
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println(
                        GetEmployeesWithProject.execute(id)
                );

            } else if (command.equals("9")) {
                System.out.println(FindTheLatestTenProjects.execute());

            } else if (command.equals("10")) {
                System.out.println(IncreaseSalaries.execute());

            } else if (command.equals("11")) {
                System.out.println(FIRST_NAME_PATTERN_PROMPT);
                String pattern = scanner.nextLine();
                System.out.println(FindEmployeesByFirstName.execute(pattern));

            } else if (command.equals("12")) {
                System.out.println(EmployeesMaximumSalaries.execute());

            } else if (command.equals("13")) {
                System.out.println(TOWN_NAME_PROMPT);
                String townName = scanner.nextLine();
                System.out.println(RemoveTowns.execute(townName));
            }

            System.out.println(EXERCISE_NUMBER_PROMPT);
            command = scanner.nextLine();
        }
    }

    public static final String EXERCISE_NUMBER_PROMPT =
            "===========================================================================================\n" +
            "Enter exercise number or END to end program:\n" +
            "   2. Change casing\n" +
            "   3. Contains Employee\n" +
            "   4. Employees with a Salary Over 50 000\n" +
            "   5. Employees from Department\n" +
            "   6. Adding a New Address and Updating the Employee\n" +
            "   7. Addresses with Employee Count\n" +
            "   8. Get Employees with Project\n" +
            "   9. Find the Latest 10 Projects\n" +
            "   10. Increase Salaries\n" +
            "   11. Find Employees by First Name\n" +
            "   12. Employees Maximum Salaries\n" +
            "   13. Remove Towns";

    public static final String EMPLOYEE_NAME_PROMPT =
            "Enter employee's first and last name:";
    public static final String EMPLOYEE_ID_PROMPT =
            "Enter employee's ID:";
    public static final String EMPLOYEE_LAST_NAME_PROMPT =
            "Enter employee's last name:";
    public static final String FIRST_NAME_PATTERN_PROMPT =
            "Enter first name start pattern:";
    public static final String TOWN_NAME_PROMPT =
            "Enter name of town to be deleted:";
}
