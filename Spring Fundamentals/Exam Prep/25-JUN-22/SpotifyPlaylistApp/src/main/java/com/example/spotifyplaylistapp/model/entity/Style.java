package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleName;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,
            unique = true)
    private StyleName name;

    @Column(columnDefinition = "TEXT")
    private String description;


    public StyleName getName() {
        return name;
    }

    public Style setName(StyleName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }
}
