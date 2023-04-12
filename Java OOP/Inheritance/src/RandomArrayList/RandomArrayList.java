package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement(){
        Random rnd = new Random();
        int randomInt = rnd.nextInt(this.size());
        T element = this.get(randomInt);
        this.remove(randomInt);
        return element;
    }
}
