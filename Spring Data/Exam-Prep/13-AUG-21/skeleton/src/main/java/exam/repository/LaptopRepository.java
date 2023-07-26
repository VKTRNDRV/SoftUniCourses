package exam.repository;

import exam.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//ToDo:
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Optional<Laptop> findFirstByMacAddress(String macAddress);

    List<Laptop> findAllByIdGreaterThanOrderByCpuSpeedDescRamDescStorageDescMacAddress(Long id);
}
