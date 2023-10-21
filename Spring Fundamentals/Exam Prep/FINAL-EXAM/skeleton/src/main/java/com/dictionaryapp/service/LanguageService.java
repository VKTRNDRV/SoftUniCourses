package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @PostConstruct
    private void init(){
        if(this.languageRepository.count() > 0){
            return;
        }

        for(LanguageName languageName : LanguageName.values()){
            Language language = new Language()
                    .setName(languageName);

            this.languageRepository.save(language);
        }
    }
}
