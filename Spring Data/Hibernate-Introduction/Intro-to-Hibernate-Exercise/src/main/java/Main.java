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
            }

            System.out.println(EXERCISE_NUMBER_PROMPT);
            command = scanner.nextLine();
        }
    }

    public static final String EXERCISE_NUMBER_PROMPT =
            "===========================================================================================\n" +
                    "Enter exercise number or END to end program:\n" +
                    "2. Change casing\n" +
                    "3. Contains Employee\n" +
                    "4. Employees with a Salary Over 50 000\n" +
                    "5. Employees from Department\n" +
                    "6. Adding a New Address and Updating the Employee\n" +
                    "7. Addresses with Employee Count\n" +
                    "8. Get Employees with Project\n";

    public static final String EMPLOYEE_NAME_PROMPT =
            "Enter employee's first and last name:";
    public static final String EMPLOYEE_ID_PROMPT =
            "Enter employee's ID:";
    public static final String EMPLOYEE_LAST_NAME_PROMPT =
            "Enter employee's last name:";

}
