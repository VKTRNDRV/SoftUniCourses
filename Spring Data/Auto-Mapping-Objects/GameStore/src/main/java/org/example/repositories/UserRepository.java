package org.example.repositories;

import org.example.domain.entities.Game;
import org.example.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);

    @Query("SELECT u.games FROM User u WHERE u.id = :userId")
    Set<Game> findGamesByUserId(Long userId);
}
