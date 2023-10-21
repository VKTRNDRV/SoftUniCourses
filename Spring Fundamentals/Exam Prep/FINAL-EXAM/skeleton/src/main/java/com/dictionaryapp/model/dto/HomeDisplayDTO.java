package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.dto.word.WordDisplayDTO;

import java.util.List;

public class HomeDisplayDTO {

    private List<WordDisplayDTO> germanWords;
    private List<WordDisplayDTO> frenchWords;
    private List<WordDisplayDTO> italianWords;
    private List<WordDisplayDTO> spanishWords;


    public int getTotalWordsCount(){
        return getGermanWordsCount() +
                getFrenchWordsCount() +
                getItalianWordsCount() +
                getSpanishWordsCount();
    }

    public int getGermanWordsCount(){
        if(germanWords == null){
            return 0;
        }

        return germanWords.size();
    }
    public int getFrenchWordsCount(){
        if(frenchWords == null){
            return 0;
        }

        return frenchWords.size();
    }
    public int getItalianWordsCount(){
        if(italianWords == null){
            return 0;
        }

        return italianWords.size();
    }
    public int getSpanishWordsCount(){
        if(spanishWords == null){
            return 0;
        }

        return spanishWords.size();
    }

    public List<WordDisplayDTO> getGermanWords() {
        return germanWords;
    }

    public HomeDisplayDTO setGermanWords(List<WordDisplayDTO> germanWords) {
        this.germanWords = germanWords;
        return this;
    }

    public List<WordDisplayDTO> getFrenchWords() {
        return frenchWords;
    }

    public HomeDisplayDTO setFrenchWords(List<WordDisplayDTO> frenchWords) {
        this.frenchWords = frenchWords;
        return this;
    }

    public List<WordDisplayDTO> getItalianWords() {
        return italianWords;
    }

    public HomeDisplayDTO setItalianWords(List<WordDisplayDTO> italianWords) {
        this.italianWords = italianWords;
        return this;
    }

    public List<WordDisplayDTO> getSpanishWords() {
        return spanishWords;
    }

    public HomeDisplayDTO setSpanishWords(List<WordDisplayDTO> spanishWords) {
        this.spanishWords = spanishWords;
        return this;
    }
}
