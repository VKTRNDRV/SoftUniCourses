import entities.Bike;
import entities.Car;
import entities.Plane;
import entities.Vehicle;
import hasEntities.PlateNumber;
import hasEntities.Truck;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("relations");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Vehicle car = new Car("Ford Focus", "Petrol", 5);
        Vehicle bike = new Bike();
        Vehicle plane = new Plane("Airbus", "Kerosene", 200);

        entityManager.persist(car);
        entityManager.persist(bike);
        entityManager.persist(plane);

        PlateNumber number = new PlateNumber("123");
        Truck truck1 = new Truck(number);
        Truck truck2 = new Truck(number);

        entityManager.persist(number);
        entityManager.persist(truck1);
        entityManager.persist(truck2);


//        Car carFromDB = entityManager.find(Car.class, 1L);
//
//        System.out.println(carFromDB.getType() +" "+  carFromDB.getModel() +" "+ carFromDB.getSeats());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}