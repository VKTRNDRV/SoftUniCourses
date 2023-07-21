package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Part;

import java.util.Optional;

// TODO:
@Repository
public interface PartsRepository extends JpaRepository<Part, Integer> {


    Optional<Part> findFirstByPartName(String partName);

    Optional<Part> findFirstById(Long id);
}
