package exercises;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ContainsEmployee {
    public static String execute(String fullName){
        String[] names = fullName.split("\\s+");
        String firstName = names[0];
        String lastName = names[1];

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot)
                .where(criteriaBuilder.like(employeeRoot.get("firstName"), firstName))
                .where(criteriaBuilder.like(employeeRoot.get("lastName"), lastName));

        Employee employee = null;
        try {
            employee = (Employee) entityManager
                    .createQuery(criteriaQuery)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            return "Yes";
        } catch (Exception e){
            entityManager.getTransaction().commit();
            return "No";
        }
    }
}
