package exercises;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class FindTheLatestTenProjects {
    public static EntityManager em;
    public static final int NUM_OF_PROJECTS_EXTRACTED = 10;
    public static final String PROJECT_STRING_FORMAT =
            "Project Name: %s\n" +
            "      Project Description: %s\n" +
            "      Project Start Date: %s\n" +
            "      Project End Date: %s";

    public static String execute(){
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        em.getTransaction().begin();
        List<Project> sortedProjects = getSortedProjects();
        StringBuilder output = new StringBuilder();
        for(Project project : sortedProjects){
            output.append(parseProjectData(project))
                    .append(System.lineSeparator());
        }
        em.getTransaction().commit();

        return output.toString().trim();
    }

    private static List<Project> getSortedProjects(){
        List<Project> projects = em
                .createQuery("from Project order by startDate desc", Project.class)
                .setMaxResults(NUM_OF_PROJECTS_EXTRACTED)
                .getResultList();

        projects.sort(Comparator.comparing(Project::getName));
        return projects;
    }

    private static String parseProjectData(Project project){
        String name = project.getName();
        String description = project.getDescription();
        String startDate = project.getStartDate().toString();
        String endDate;
        try {
            endDate = project.getEndDate().toString();
        }catch (NullPointerException e){
            endDate = "null";
        }

        return String.format(PROJECT_STRING_FORMAT
                , name
                , description
                , startDate
                , endDate);
    }
}
