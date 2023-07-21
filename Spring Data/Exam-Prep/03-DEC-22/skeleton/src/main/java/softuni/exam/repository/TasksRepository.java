package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.CarType;
import softuni.exam.models.entity.Task;

import java.util.List;

// TODO:
@Repository
public interface TasksRepository extends JpaRepository<Task, Integer> {

//    @Query(value = "select t from Task t join t.car c where c.carType = :carType order by t.price")
    public List<Task> getTasksByCarCarTypeOrderByPriceDesc(CarType carType);
}
