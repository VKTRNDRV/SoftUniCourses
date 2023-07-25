package softuni.exam.service;


import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;

import java.io.IOException;
import java.util.List;
import java.util.Set;

//ToDo - Before start App implement this Service and set areImported to return false
public interface PictureService {

    boolean areImported();

    String readPicturesFromFile() throws IOException;
	
	String importPictures() throws IOException;

    Set<Picture> getPicturesByCar(Car car);

    Integer getCountOfPicturesByCar(Car car);
}
