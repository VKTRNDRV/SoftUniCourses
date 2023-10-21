package com.dictionaryapp.model.dto.word;

public class WordDisplayDTO {

    private Long id;
    private String term;
    private String translation;
    private String example;
    private String addedBy;
    private String inputDate;



    public Long getId() {
        return id;
    }

    public WordDisplayDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public WordDisplayDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordDisplayDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordDisplayDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public WordDisplayDTO setAddedBy(String addedBy) {
        this.addedBy = addedBy;
        return this;
    }

    public String getInputDate() {
        return inputDate;
    }

    public WordDisplayDTO setInputDate(String inputDate) {
        this.inputDate = inputDate;
        return this;
    }
}
