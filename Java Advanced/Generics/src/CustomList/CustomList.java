package CustomList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

    public List<T> getElements(){
        return this.elements;
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.remove(index);
        }
        throw new IndexOutOfBoundsException("Invalid index");
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < elements.size() && index2 >= 0 && index2 < elements.size()) {
            Collections.swap(elements, index1, index2);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T item : elements) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return Collections.max(elements);
    }

    public T getMin() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return Collections.min(elements);
    }
}
