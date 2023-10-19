package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false,
            unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,
            unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Song> songs;


    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public User setSongs(List<Song> songs) {
        this.songs = songs;
        return this;
    }

    public boolean containsSong(Song song){
        long id = song.getId();
        for(Song songInPlaylist : this.songs){
            if(songInPlaylist.getId() == id){
                return true;
            }
        }

        return false;
    }

    public void addSongToPlaylist(Song song){
        if(this.containsSong(song)) return;
        this.songs.add(song);
    }
}
