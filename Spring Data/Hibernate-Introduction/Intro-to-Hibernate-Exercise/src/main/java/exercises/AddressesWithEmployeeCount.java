package exercises;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AddressesWithEmployeeCount {
    private static EntityManager em;

    private static final String OUTPUT_FORMAT = "%s, %s - %d employees";
    public static String[] getSortedInfo(){
        em = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        em.getTransaction().begin();

        List<Address> top10Addresses = em.createQuery(
                "FROM Address order by employees.size desc ", Address.class
                )
                .setMaxResults(10)
                .getResultList();

        String[] output = new String[top10Addresses.size()];
        for(int i = 0; i < output.length; i++){
            Address address = top10Addresses.get(i);
            String addressText = address.getText();
            String townName = "";
            try {
                townName = address.getTown().getName();
            }catch (NullPointerException e){
                townName = "Unknown";
            }
            int employeesCount = address.getEmployees().size();
            output[i] = String.format(OUTPUT_FORMAT
                    , addressText
                    , townName
                    , employeesCount);
        }

        em.getTransaction().commit();
        return output;
    }
}
