package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.HomeDisplayDTO;
import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.dto.SongDisplayDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private SongRepository songRepository;

    private StyleRepository styleRepository;

    private UserRepository userRepository;

    private LoggedUser loggedUser;

    private final int SECONDS_IN_A_MINUTE = 60;

    @Autowired
    public SongService(SongRepository songRepository, StyleRepository styleRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public void addSong(SongAddDTO songAddDTO) {

        Song song = new Song()
                .setTitle(songAddDTO.getTitle())
                .setDuration(songAddDTO.getDuration())
                .setPerformer(songAddDTO.getPerformer())
                .setReleaseDate(LocalDate.parse(songAddDTO.getReleaseDate()))
                .setStyle(this.styleRepository.findFirstByName(
                        StyleName.valueOf(songAddDTO.getStyle())).get());

        this.songRepository.save(song);
    }

    public HomeDisplayDTO getHomeDisplay(){
        List<Song> allSongs = this.songRepository.findAll();
        List<SongDisplayDTO> playlist = new ArrayList<>();
        List<SongDisplayDTO> rockSongs = new ArrayList<>();
        List<SongDisplayDTO> popSongs = new ArrayList<>();
        List<SongDisplayDTO> jazzSongs = new ArrayList<>();

        User user = this.userRepository.findFirstByUsername(
                loggedUser.getUsername()).get();

        for(Song song : allSongs){
            if(user.containsSong(song)){
                playlist.add(mapSongToDisplayDTO(song));
                continue;
            }

            switch (song.getStyle().getName()){
                case ROCK:
                    rockSongs.add(mapSongToDisplayDTO(song));
                    break;
                case POP:
                    popSongs.add(mapSongToDisplayDTO(song));
                    break;
                case JAZZ:
                    jazzSongs.add(mapSongToDisplayDTO(song));
                    break;
            }
        }

        HomeDisplayDTO dto = new HomeDisplayDTO()
                .setTotalDuration(getTotalDuration(user.getSongs()))
                .setPlaylist(playlist)
                .setPopSongs(popSongs)
                .setRockSongs(rockSongs)
                .setJazzSongs(jazzSongs);

        return dto;
    }

    private String toMinutes(int seconds){
        int minutes = seconds / SECONDS_IN_A_MINUTE;
        seconds -= minutes * SECONDS_IN_A_MINUTE;
        return String.format("%d : %d", minutes, seconds);
    }
    private String getTotalDuration(Collection<Song> songs){
        int totalSeconds = 0;
        for(Song song : songs){
            totalSeconds += song.getDuration();
        }

        return toMinutes(totalSeconds);
    }

    public SongDisplayDTO mapSongToDisplayDTO(Song song){
        return new SongDisplayDTO()
                .setId(song.getId())
                .setTitle(song.getTitle())
                .setDuration(this.toMinutes(song.getDuration()))
                .setPerformer(song.getPerformer());
    }

    public void clearPlaylist() {
        User user = this.userRepository.findFirstByUsername(
                loggedUser.getUsername()).get();

        user.setSongs(new ArrayList<>());

        this.userRepository.save(user);
    }

    public void addSongToPlaylist(Long id) {
        Optional<Song> songOpt = this.songRepository.findById(id);
        if(songOpt.isEmpty()){
            return;
        }

        Song song = songOpt.get();
        User user = this.userRepository.findFirstByUsername(
                loggedUser.getUsername()).get();

        user.addSongToPlaylist(song);
        this.userRepository.save(user);
    }
}
