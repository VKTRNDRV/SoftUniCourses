package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findFirstBySerialNumber(String serialNumber);

    @Query(value = "select count(distinct t.id) from Ticket t where t.passenger = :passenger")
    Integer getCountOfTicketsByPassenger(Passenger passenger);
}
