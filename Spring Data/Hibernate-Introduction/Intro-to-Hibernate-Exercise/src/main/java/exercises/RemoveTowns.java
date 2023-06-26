package exercises;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveTowns {
    private static EntityManager em;
    private static final String OUTPUT_FORMAT_MORE_THAN_ONE_ADDRESS =
            "%d addresses in %s deleted";
    private static final String OUTPUT_FORMAT_ONE_ADDRESS =
            "1 address in %s deleted";

    public static String execute(String townName){
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();
        em.getTransaction().begin();
        Town town = em.createQuery("FROM Town "
                        + "WHERE name = :town", Town.class)
                .setParameter("town", townName)
                .getSingleResult();

        List<Address> addresses = em
                .createQuery("FROM Address WHERE town.id= :id", Address.class)
                .setParameter("id", town.getId())
                .getResultList();
        int addressesCount = addresses.size();

        addresses.forEach(address -> address
                .getEmployees()
                .forEach(employee -> employee.setAddress(null)));

        addresses.forEach(address -> em.remove(address));
        em.remove(town);
        em.getTransaction().commit();
        if(addressesCount > 1){
            return String.format(OUTPUT_FORMAT_MORE_THAN_ONE_ADDRESS
                    , addressesCount
                    , town.getName());
        }else {
            return String.format(OUTPUT_FORMAT_ONE_ADDRESS
                    , town.getName());
        }
    }
}
