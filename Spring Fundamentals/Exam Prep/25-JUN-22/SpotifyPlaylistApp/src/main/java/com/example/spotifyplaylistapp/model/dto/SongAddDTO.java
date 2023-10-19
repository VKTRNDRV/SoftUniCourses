package com.example.spotifyplaylistapp.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Date;

public class SongAddDTO {

    @Length(min = 2, max = 20, message = "Length must be between 2 and 20 characters")
    private String title;

    @Length(min = 3, max = 20, message = "Length must be between 3 and 20 characters")
    private String performer;

    @Positive(message = "The duration (in seconds) must be a positive number")
    private Integer duration;

//    @PastOrPresent(message = "The Release Date cannot be in the future")
    private String releaseDate;

    @NotBlank
    private String style;



    public String getTitle() {
        return title;
    }

    public SongAddDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongAddDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddDTO setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String  getReleaseDate() {
        return releaseDate;
    }

    public SongAddDTO setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public SongAddDTO setStyle(String style) {
        this.style = style;
        return this;
    }
}
