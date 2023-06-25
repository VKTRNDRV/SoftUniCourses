package exercises;

import entities.Employee;
import org.hibernate.type.BigDecimalType;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class EmployeesFromDepartment {

    public static final int RESEARCH_AND_DEVELOPMENT_DEPARTMENT_ID = 6;

    public static final String OUTPUT_FORMAT = "%s %s from Research and Development - $%.2f";
    public static String[] getSortedEmployees(){
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root)
                .where(
                        builder.equal(root.get("department")
                        , RESEARCH_AND_DEVELOPMENT_DEPARTMENT_ID)
                );
        List<Employee> employees = entityManager.createQuery(criteriaQuery).getResultList();

        entityManager.getTransaction().commit();

        employees.sort(
                Comparator.comparing(Employee::getSalary)
                        .thenComparingInt(Employee::getId)
        );

        String[] output = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            output[i] = String.format(
                    OUTPUT_FORMAT
                    , employee.getFirstName()
                    , employee.getLastName()
                    , employee.getSalary()
            );
        }
        return output;
    }
}
