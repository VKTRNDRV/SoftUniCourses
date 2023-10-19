package com.example.spotifyplaylistapp.model.dto;

import java.util.List;

public class HomeDisplayDTO {

    private List<SongDisplayDTO> playlist;

    private String totalDuration;

    private List<SongDisplayDTO> rockSongs;

    private List<SongDisplayDTO> popSongs;

    private List<SongDisplayDTO> jazzSongs;


    public List<SongDisplayDTO> getPlaylist() {
        return playlist;
    }

    public HomeDisplayDTO setPlaylist(List<SongDisplayDTO> playlist) {
        this.playlist = playlist;
        return this;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public HomeDisplayDTO setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
        return this;
    }

    public List<SongDisplayDTO> getRockSongs() {
        return rockSongs;
    }

    public HomeDisplayDTO setRockSongs(List<SongDisplayDTO> rockSongs) {
        this.rockSongs = rockSongs;
        return this;
    }

    public List<SongDisplayDTO> getPopSongs() {
        return popSongs;
    }

    public HomeDisplayDTO setPopSongs(List<SongDisplayDTO> popSongs) {
        this.popSongs = popSongs;
        return this;
    }

    public List<SongDisplayDTO> getJazzSongs() {
        return jazzSongs;
    }

    public HomeDisplayDTO setJazzSongs(List<SongDisplayDTO> jazzSongs) {
        this.jazzSongs = jazzSongs;
        return this;
    }
}
