package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person{
    @Column(name = "avg_grade")
    private double averageGrade;

    @Column(name = "attendance")
    private String attendance;

    @ManyToMany(mappedBy = "students"
            , targetEntity = Course.class)
    private Set<Course> courses;
}
