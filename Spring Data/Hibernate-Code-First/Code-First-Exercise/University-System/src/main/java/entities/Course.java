package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "credits")
    private String credits;

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id"
            , referencedColumnName = "id")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "courses_students"
            , joinColumns =
    @JoinColumn(name = "student_id", referencedColumnName = "id")
            , inverseJoinColumns =
    @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Student> students;
}
