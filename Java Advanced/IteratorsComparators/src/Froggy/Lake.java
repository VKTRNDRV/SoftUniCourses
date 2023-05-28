package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer>{
    private List<Integer> numbers;

    public Lake(){
        numbers = new ArrayList<>();
    }

    public void add(int num){
        this.numbers.add(num);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            int num;
            if(numbers.size() % 2 == 0) {
                if (index < numbers.size() / 2) {
                    num = numbers.get(index * 2);
                } else {
                    num = numbers.get(1 + index * 2 - (numbers.size()));
                }
            }else{
                if (index <= numbers.size() / 2) {
                    num = numbers.get(index * 2);
                } else {
                    num = numbers.get(index*2 - (numbers.size()));
                }
            }
            index++;
            return num;
        }
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterator<Integer> iterator = this.iterator();
        while (iterator.hasNext()){
            int num = iterator.next();
            action.accept(num);
        }
    }
}
