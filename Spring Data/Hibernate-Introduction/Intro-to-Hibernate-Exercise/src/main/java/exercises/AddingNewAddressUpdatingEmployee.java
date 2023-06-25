package exercises;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AddingNewAddressUpdatingEmployee {

    private static EntityManager entityManager;
    private static final String VITOSHKA_ADDRESS_TEXT = "Vitoshka 15";


    public static void execute(String lastName){
        entityManager = Persistence
                .createEntityManagerFactory("PU_Name")
                .createEntityManager();

        entityManager.getTransaction().begin();

        createAndAddAddress();
        Address address = getVitoshkaAddress();
        Employee employee = getEmployeeByLastName(lastName);

        assert employee != null;
        employee.setAddress(address);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
    }

    private static void createAndAddAddress(){
        Address vitoshkaAddress = new Address();
        vitoshkaAddress.setText(VITOSHKA_ADDRESS_TEXT);
        entityManager.persist(vitoshkaAddress);
    }

    private static Address getVitoshkaAddress(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
        Root<Address> root = criteria.from(Address.class);
        criteria
                .select(root)
                .where(builder.like(root.get("text"), VITOSHKA_ADDRESS_TEXT));

        try {
            return entityManager
                    .createQuery(criteria)
                    .getResultList().get(0);

        }catch (NoResultException e){
            return null;
        }
    }

    private static Employee getEmployeeByLastName(String lastName){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria
                .select(root)
                .where(builder.like(root.get("lastName"), lastName));

        try {
            return entityManager
                    .createQuery(criteria)
                    .getSingleResult();

        }catch (NoResultException e){
            return null;
        }
    }
}
