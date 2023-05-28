package CustomStack;

import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

public class CustomStack implements Iterable<Integer> {
    private Stack<Integer> contents;

    public CustomStack(){
        this.contents = new Stack<>();
    }

    public void push(int... numbers){
        for(int n : numbers){
            contents.push(n);
        }
    }

    public int pop(){
        if(contents.isEmpty()){
            throw new IllegalStateException("No elements");
        }else{
            return contents.pop();
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomStackIterator();
    }

    private final class CustomStackIterator implements Iterator<Integer>{
        @Override
        public boolean hasNext() {
            return !contents.isEmpty();
        }

        @Override
        public Integer next() {
            return contents.pop();
        }
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Stack<Integer> temp = new Stack<>();
        while (!contents.isEmpty()){
            int n = contents.pop();
            temp.push(n);
            action.accept(n);
        }

        while (!temp.isEmpty()){
            contents.push(temp.pop());
        }
    }
}
