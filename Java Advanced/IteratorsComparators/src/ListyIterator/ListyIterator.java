package ListyIterator;

import java.util.*;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;
    private int index;

    public ListyIterator(String... elements){
        this.elements = new ArrayList<>();
        this.elements.addAll(Arrays.asList(elements));
        this.index = 0;
    }

    public ListyIterator(){
        this.elements = new ArrayList<>();
        this.index = 0;
    }

    public void add(String element){
        this.elements.add(element);
    }

    public boolean hasNext(){
        return this.index < this.elements.size() - 1;
    }

    public boolean move(){
        if(this.hasNext()){
            index++;
            return true;
        }
        return false;
    }

    public void print(){
        if(this.index < this.elements.size()) {
            System.out.println(this.elements.get(this.index));
        }else {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    public void printAll(){
        if(this.elements.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }else {
            this.forEach(s -> System.out.printf("%s ", s));
            System.out.println();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIteratorIterator();
    }

     private final class ListyIteratorIterator implements Iterator<String> {
        int counter = 0;
        @Override
        public boolean hasNext(){
            return this.counter < elements.size();
        }

        @Override
        public String next() {
            return elements.get(counter++);
        }
    };

    @Override
    public void forEach(Consumer<? super String> action) {
        for(String element : this.elements){
            action.accept(element);
        }
    }

}



