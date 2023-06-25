package exercises;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {
    public static void execute(){
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        entityManager.getTransaction().begin();

        // get all towns
        List<Town> allTowns = entityManager
                .createQuery("FROM Town", Town.class)
                .getResultList();

        allTowns.forEach(t -> System.out.println(t.getName()));

        // remove towns > 5 chars
        for (int i = 0; i < allTowns.size(); i++) {
            Town town = allTowns.get(i);
            if(town.getName().length() > 5){
                entityManager.detach(town);
                allTowns.remove(i);
                i--;
            }
        }

        // change names and persist towns
        for (Town town : allTowns){
            if (entityManager.contains(town)){
                town.setName(town.getName()
                        .toUpperCase());
                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
    }
}
