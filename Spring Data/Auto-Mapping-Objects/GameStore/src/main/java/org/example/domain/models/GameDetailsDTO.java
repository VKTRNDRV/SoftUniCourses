package org.example.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.entities.Game;
import org.modelmapper.PropertyMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
public class GameDetailsDTO {
    private String title;
    private String price;
    private String description;
    private String releaseDate;




    public static PropertyMap<Game, GameDetailsDTO> CONVERT_TO_DTO_MAP = new PropertyMap<Game, GameDetailsDTO>() {
        @Override
        protected void configure() {
            map().setTitle("Title: " + source.getTitle());
            map().setPrice(String.format("Price: %.2f", source.getPrice()));
            map().setDescription("Description: " + source.getDescription());
            using(ctx -> ((LocalDate) ctx.getSource()).toString())
                    .map(source.getReleaseDate(), destination.getReleaseDate());
        }
    };

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(title).append(System.lineSeparator())
                .append(price).append(System.lineSeparator())
                .append(description).append(System.lineSeparator())
                .append(releaseDate);
        return output.toString();
    }
}
