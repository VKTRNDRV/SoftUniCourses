package com.example.mobilelele.models.entities;

import com.example.mobilelele.models.enums.Category;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @Column(name = "image_url",
            columnDefinition = "VARCHAR(512)")
    private String imageUrl;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}

