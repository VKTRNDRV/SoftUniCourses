package com.example.battleships.repository;

import com.example.battleships.domain.entity.Ship;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<List<Ship>> findAllByUserId(Long id);

    Optional<Ship> findByName(String shipName);
}
