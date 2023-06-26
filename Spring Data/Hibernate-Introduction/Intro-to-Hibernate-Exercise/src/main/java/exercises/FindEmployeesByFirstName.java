package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class FindEmployeesByFirstName {
    private static EntityManager em;
    private static final String EMPLOYEE_INFO_FORMAT = "%s %s - %s - ($%.2f)";

    public static String execute(String pattern){
        pattern = pattern.toLowerCase().concat("%");
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();
        em.getTransaction().begin();
        StringBuilder output =new StringBuilder();
        List<Employee> employees = getEmployeesByPattern(pattern);
        for(Employee employee : employees){
            output.append(parseEmployeeInfo(employee))
                    .append(System.lineSeparator());
        }
        em.getTransaction().commit();

        return output.toString().trim();
    }

    private static List<Employee> getEmployeesByPattern(String pattern){
        return em.createQuery("from Employee " +
                    "where lower(firstName) like :patt", Employee.class)
                .setParameter("patt", pattern)
                .getResultList();
    }

    private static String parseEmployeeInfo(Employee employee){
        return String.format(EMPLOYEE_INFO_FORMAT
                , employee.getFirstName()
                , employee.getLastName()
                , employee.getJobTitle()
                , employee.getSalary());
    }
}
