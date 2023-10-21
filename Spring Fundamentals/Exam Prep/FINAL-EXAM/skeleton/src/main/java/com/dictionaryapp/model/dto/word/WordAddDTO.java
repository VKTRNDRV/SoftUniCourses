package com.dictionaryapp.model.dto.word;

import com.dictionaryapp.validation.StringDatePastOrPresent;
import com.dictionaryapp.validation.ValidLanguageOption;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WordAddDTO {

    @NotBlank
    @Size(min = 2, max = 40, message = "Term length must be between 2 and 40 characters")
    private String term;

    @NotBlank
    @Size(min = 2, max = 80, message = "Translation length must be between 2 and 80 characters")
    private String translation;

    @NotBlank
    @Size(min = 2, max = 200, message = "Example length must be between 2 and 200 characters")
    private String example;

    @NotBlank
    @StringDatePastOrPresent
    private String inputDate;

    @NotBlank
    @ValidLanguageOption
    private String language;


    public String getTerm() {
        return term;
    }

    public WordAddDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordAddDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordAddDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public String getInputDate() {
        return inputDate;
    }

    public WordAddDTO setInputDate(String inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public WordAddDTO setLanguage(String language) {
        this.language = language;
        return this;
    }
}
