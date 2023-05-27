package CustomList;

import java.util.Collections;

public class Sorter {

    static <T extends Comparable<T>> void sort(CustomList<T> customList){
        Collections.sort(customList.getElements());
    }
}
