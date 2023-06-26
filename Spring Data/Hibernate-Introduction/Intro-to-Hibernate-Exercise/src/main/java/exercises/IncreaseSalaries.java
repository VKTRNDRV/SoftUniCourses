package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    private static EntityManager em;
    private static final double INCREASE_MULTIPLICAND = 1.12;
    private static final String EMPLOYEE_INFO_FORMAT = "%s %s ($%.2f)";
    public static String execute(){
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        em.getTransaction().begin();
        List<Employee> employees = getEmployeesFromDepartments();
        StringBuilder output = new StringBuilder();
        for(Employee employee : employees){
            employee.setSalary(employee
                    .getSalary()
                    .multiply(BigDecimal.valueOf(INCREASE_MULTIPLICAND)));
            em.persist(employee);

            output.append(getParsedEmployeeInfo(employee))
                    .append(System.lineSeparator());
        }

        em.getTransaction().commit();
        return output.toString().trim();
    }

    private static List<Employee> getEmployeesFromDepartments(){
        List<Employee> employees = em
                .createQuery(
                        "from Employee " +
                        "where department.name = :engineering " +
                        "or department.name = :tooldesign " +
                        "or department.name = :marketing " +
                        "or department.name = :infserv", Employee.class)
                .setParameter("engineering", "Engineering")
                .setParameter("tooldesign", "Tool Design")
                .setParameter("marketing", "Marketing")
                .setParameter("infserv", "Information Services")
                .getResultList();
        return employees;
    }

    private static String getParsedEmployeeInfo(Employee employee){
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        BigDecimal salary = employee.getSalary();
        return String.format(EMPLOYEE_INFO_FORMAT
                , firstName
                , lastName
                , salary);
    }
}
