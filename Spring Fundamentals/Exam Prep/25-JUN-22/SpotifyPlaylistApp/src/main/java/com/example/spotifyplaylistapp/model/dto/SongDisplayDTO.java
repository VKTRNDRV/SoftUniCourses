package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.entity.Song;

public class SongDisplayDTO {

    private Long id;

    private String title;

    private String performer;

    private String duration;


    public Long getId() {
        return id;
    }

    public SongDisplayDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongDisplayDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongDisplayDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public SongDisplayDTO setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String toString(){
        return String.format("{%s} - {%s} (%s min)", performer, title, duration);
    }
}
