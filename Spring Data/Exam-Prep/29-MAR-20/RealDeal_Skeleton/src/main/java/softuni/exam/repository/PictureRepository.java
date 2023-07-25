package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//ToDo
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    Optional<Picture> findFirstByName(String name);

    Set<Picture> findAllByCar(Car car);

    @Query(value = "SELECT count(distinct p.id) from Picture p where p.car = :car")
    Integer getCountOfPicsByCar(Car car);
}
