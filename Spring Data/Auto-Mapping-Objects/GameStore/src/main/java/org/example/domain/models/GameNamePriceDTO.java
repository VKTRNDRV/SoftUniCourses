package org.example.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.entities.Game;
import org.modelmapper.PropertyMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameNamePriceDTO {
    private String title;
    private String price;

    @Override
    public String toString(){
        return title + " " + price;
    }

    public static final PropertyMap<Game, GameNamePriceDTO> CONVERT_TO_DTO_MAP = new PropertyMap<Game, GameNamePriceDTO>() {
        @Override
        protected void configure() {
            map().setTitle(source.getTitle());
            map().setPrice(String.format("%.2f", source.getPrice()));
        }
    };
}
