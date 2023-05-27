package GenericBox;

import java.util.List;

public class Box<T extends Comparable<T>> {
    private T data;

    public Box(T data){
        this.data = data;
    }

    static <T> void swap(List<T> list, int i1, int i2){
        T item1 = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, item1);
    }

    static <T extends Comparable<T>> int countGreater(List<T> list, T element){
        int count = 0;
        for(T item : list){
            if(item.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString(){
        return String.format("%s: %s",
                this.data.getClass().getName(),
                String.valueOf(this.data));
    }
}
