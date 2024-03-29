package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Car;

import java.util.Optional;

//ToDo
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findFirstByMakeAndModel(String make, String model);
}
