package exercises;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesMaximumSalaries {
    private static EntityManager em;

    public static String execute(){
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();
        em.getTransaction().begin();
        StringBuilder output = new StringBuilder();
        em.createQuery("SELECT department.name, max(salary)" +
                " FROM Employee " +
                " GROUP BY department.name" +
                " HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                 .forEach(objects -> {
                     output.append(objects[0] + " " + objects[1])
                             .append(System.lineSeparator());
                 });;
        em.getTransaction().commit();
        return output.toString().trim();
    }
}
