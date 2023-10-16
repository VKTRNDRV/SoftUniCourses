package com.example.battleships.repository;

import com.example.battleships.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByUsername(String username);

    Optional<User> findFirstByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findByIdNot(Long id);
}
