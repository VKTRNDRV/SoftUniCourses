package com.example.bookshopsystem.models.entities;

import com.example.bookshopsystem.models.enums.AgeRestriction;
import com.example.bookshopsystem.models.enums.EditionType;
import jakarta.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    public String getBookTitleReleaseDateCopiesFormat() {
        return this.title + " " + this.releaseDate + " " + this.copies;
    }

}
