package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StyleService {

    private StyleRepository styleRepository;

    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @PostConstruct
    private void init(){
        if(this.styleRepository.count() > 0){
            return;
        }

        for(StyleName styleName : StyleName.values()){
            this.styleRepository.save(new Style()
                    .setName(styleName));
        }
    }
}
