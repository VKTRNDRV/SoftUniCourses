package com.example.productsshop.repositories;

import com.example.productsshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM `products_shop`.users order by rand() limit 1"
            , nativeQuery = true)
    Optional<User> getRandomUser();

    @Query(value = "select u from User u join  u.sellingProducts sp where sp.buyer is not null order by u.lastName, u.firstName")
    List<User> findUsersWithSoldProductsOrderedByLastNameFirstName();

    @Query(value = "select u from User u join fetch u.sellingProducts sp where u = :user and sp.buyer is not null")
    User getUserWithSoldProducts(User user);
}
