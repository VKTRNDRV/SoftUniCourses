package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.enums.DayOfWeek;

import java.util.List;
import java.util.Optional;

// TODO:
@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findFirstByCityAndDayOfWeek(City city, DayOfWeek dayOfWeek);

    List<Forecast> findAllByDayOfWeekOrderByMaxTemperatureDescId(DayOfWeek dayOfWeek);
}
