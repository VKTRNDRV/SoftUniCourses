package exercises;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GetEmployeesWithProject {
    public static EntityManager em;

    public static final String EMPLOYEE_FORMAT = "%s %s - %s";
    public static final String PROJECT_FORMAT = "      %s";

    public static String execute(int id){
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        em.getTransaction().begin();
        Employee employee = getEmployeeByID(id);
        em.getTransaction().commit();

        List<Project> sortedProjects = getSortedProjects(employee);
        return getFormattedInfo(employee, sortedProjects);

    }

    private static Employee getEmployeeByID(int id){
        try {
            return em.createQuery("from Employee where id = :idParam", Employee.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    private static List<Project> getSortedProjects(Employee employee){
        Set<Project> projects = employee.getProjects();
        List<Project> sortedProjects = new ArrayList<>();
        sortedProjects.addAll(projects);
        sortedProjects.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return sortedProjects;
    }

    private static String getFormattedInfo(Employee employee, List<Project> sortedProjects){
        StringBuilder output = new StringBuilder();
        output.append(String.format(EMPLOYEE_FORMAT
                        , employee.getFirstName()
                        , employee.getLastName()
                        , employee.getJobTitle()))
                .append(System.lineSeparator());
        for(Project project : sortedProjects){
            output.append(String.format(PROJECT_FORMAT, project.getName()))
                    .append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}