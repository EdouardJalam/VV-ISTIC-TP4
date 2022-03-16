package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryHeap<T> {

    private Comparator<T> comparator;
	private List<T> list = new ArrayList<T>();

    public BinaryHeap(Comparator<T> comparator) {
    	this.comparator = comparator;
    }

    public Comparator<T> getComparator() {
		return comparator;
	}

	public T pop() {
    	if(list.isEmpty()) throw new NoSuchElementException();
    	return list.remove(list.size()-1);
    }

    public T peek() {
    	if(list.isEmpty()) throw new NoSuchElementException();
    	return list.get(list.size()-1);
    }

    public void push(T element) {
    	list.add(element);
    	list.sort(comparator);
    }

    public int count() {
    	return list.size();
    }


}
