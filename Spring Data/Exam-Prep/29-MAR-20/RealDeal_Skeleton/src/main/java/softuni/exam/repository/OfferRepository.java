package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Offer;

import java.time.LocalDateTime;
import java.util.Optional;

//ToDo
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findFirstByDescriptionAndAddedOn(String description, LocalDateTime addedOn);
}
