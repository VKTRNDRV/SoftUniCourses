package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeesWithSalaryOver50K {
    public static String[] getFirstNames(){
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery
                .select(root)
                .where(builder.greaterThan(root.get("salary"), 50000));

         List<Employee> employees = entityManager
                .createQuery(criteriaQuery)
                 .getResultList();
         String[] firstNames = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            firstNames[i] = employees
                    .get(i)
                    .getFirstName();
        }

        entityManager.getTransaction().commit();
        return firstNames;
    }
}
