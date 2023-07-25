package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Picture;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//ToDo
@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> findFirstByPath(String path);

    List<Picture> findAllBySizeGreaterThanOrderBySize(Double size);
}
