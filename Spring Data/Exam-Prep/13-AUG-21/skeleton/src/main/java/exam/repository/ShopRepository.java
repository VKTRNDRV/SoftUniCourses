package exam.repository;

import exam.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//ToDo:
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findFirstByName(String name);
}
