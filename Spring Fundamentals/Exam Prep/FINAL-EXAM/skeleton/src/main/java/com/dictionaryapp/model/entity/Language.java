package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,
            unique = true)
    private LanguageName name;

    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String description;


    public LanguageName getName() {
        return name;
    }

    public Language setName(LanguageName name) {
        this.name = name;
        String description = "";
        switch (name){
            case GERMAN:
                description = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
                break;
            case SPANISH:
                description = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
                break;
            case FRENCH:
                description = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
                break;
            case ITALIAN:
                description = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
                break;
        }
        setDescription(description);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Language setDescription(String description) {
        this.description = description;
        return this;
    }
}
