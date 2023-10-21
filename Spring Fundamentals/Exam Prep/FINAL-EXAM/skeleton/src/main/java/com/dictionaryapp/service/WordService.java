package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.HomeDisplayDTO;
import com.dictionaryapp.model.dto.word.WordAddDTO;
import com.dictionaryapp.model.dto.word.WordDisplayDTO;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    private UserRepository userRepository;
    private LoggedUser loggedUser;
    private LanguageRepository languageRepository;
    private WordRepository wordRepository;

    @Autowired
    public WordService(UserRepository userRepository, LoggedUser loggedUser, LanguageRepository languageRepository, WordRepository wordRepository) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.languageRepository = languageRepository;
        this.wordRepository = wordRepository;
    }

    public void addWord(WordAddDTO wordAddDTO) {
        Word word = mapToWord(wordAddDTO);
        this.wordRepository.save(word);
    }

    private Word mapToWord(WordAddDTO wordAddDTO) {
        return new Word()
                .setTerm(wordAddDTO.getTerm())
                .setTranslation(wordAddDTO.getTranslation())
                .setExample(wordAddDTO.getExample())
                .setInputDate(LocalDate.parse(
                        wordAddDTO.getInputDate()))
                .setLanguage(this.languageRepository
                        .findFirstByName(LanguageName.valueOf(
                                wordAddDTO.getLanguage()))
                        .get())
                .setAddedBy(this.userRepository.findFirstByUsername(
                        loggedUser.getUsername())
                        .get());
    }

    public HomeDisplayDTO getHomeDisplay() {
        List<Word> allWords = wordRepository.findAll();
        List<WordDisplayDTO> germanWords = new ArrayList<>();
        List<WordDisplayDTO> frenchWords = new ArrayList<>();
        List<WordDisplayDTO> italianWords = new ArrayList<>();
        List<WordDisplayDTO> spanishWords = new ArrayList<>();
        for(Word word : allWords){
            WordDisplayDTO wordDTO = mapToDisplayDTO(word);
            switch (word.getLanguage().getName()){
                case GERMAN:
                    germanWords.add(wordDTO);
                    break;
                case FRENCH:
                    frenchWords.add(wordDTO);
                    break;
                case ITALIAN:
                    italianWords.add(wordDTO);
                    break;
                case SPANISH:
                    spanishWords.add(wordDTO);
                    break;
            }
        }
        return new HomeDisplayDTO()
                .setGermanWords(germanWords)
                .setFrenchWords(frenchWords)
                .setItalianWords(italianWords)
                .setSpanishWords(spanishWords);
    }

    private WordDisplayDTO mapToDisplayDTO(Word word) {
        return new WordDisplayDTO()
                .setId(word.getId())
                .setTerm(word.getTerm())
                .setTranslation(word.getTranslation())
                .setExample(word.getExample())
                .setInputDate(word.getInputDate()
                        .toString())
                .setAddedBy(word.getAddedBy()
                        .getUsername());
    }

    public void removeAllWords() {
        this.wordRepository.deleteAll();;
    }

    public void removeWordById(Long id) {
        this.wordRepository.deleteById(id);
    }
}
