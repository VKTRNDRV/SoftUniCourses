package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;

import java.util.List;

//ToDo
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByUser(User user);
}
