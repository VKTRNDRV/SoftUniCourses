package hiberspring.repository;

import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = "SELECT distinct p.branch from Product p")
    List<Branch> getBranchesWithProducts();
}
