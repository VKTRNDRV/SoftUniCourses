package com.example.mobilelele.repositories;

import com.example.mobilelele.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<User, Long> {

}
