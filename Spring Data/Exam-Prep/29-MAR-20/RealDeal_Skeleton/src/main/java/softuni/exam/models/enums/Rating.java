package softuni.exam.models.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rating {
    GOOD,
    BAD,
    UNKNOWN;

    public static List<String> getAsStrings(){
        List<String> ratings = new ArrayList<>();
        for(Rating rating : Rating.values()){
            ratings.add(rating.toString());
        }
        return ratings;
    }

    public static boolean isValid(String str){
        return !Arrays.stream(Rating.values())
                .filter(rating -> rating.toString().equals(str))
                .collect(Collectors.toList())
                .isEmpty();
    }

}
