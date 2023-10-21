package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word extends BaseEntity{

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    @Column(columnDefinition = "TEXT")
    private String example;

    @Column(nullable = false, name = "input_date")
    private LocalDate inputDate;

    @ManyToOne
    @JoinColumn(name = "added_by_id")
    private User addedBy;

    @ManyToOne
    @JoinColumn(name = "langauge_id",
            nullable = false)
    private Language language;


    public String getTerm() {
        return term;
    }

    public Word setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public Word setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public Word setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public Word setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public Word setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Word setLanguage(Language language) {
        this.language = language;
        return this;
    }
}
