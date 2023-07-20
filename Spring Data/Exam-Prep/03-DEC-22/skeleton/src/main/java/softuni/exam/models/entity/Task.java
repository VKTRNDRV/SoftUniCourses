package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{
    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, columnDefinition = "")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "parts_id")
    private Part part;
}
