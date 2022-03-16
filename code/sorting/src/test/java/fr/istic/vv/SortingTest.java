package fr.istic.vv;
import net.jqwik.api.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingTest {
    @Property
    boolean bubblesortTestInteger(@ForAll("arrayInteger") Integer[] tab) {
    	Comparator<Integer> c = (Integer a,Integer b) -> Integer.compare(a, b);
    	Integer[] t = Sorting.bubblesort(tab, c);
        List<Integer> l = Arrays.asList(tab);
        l.sort(c);
        return Arrays.equals(t,l.toArray(new Integer[0]));
    }
    
    @Property
    boolean quicksortTestInteger(@ForAll("arrayInteger") Integer[] tab) {
    	Comparator<Integer> c = (Integer a,Integer b) -> Integer.compare(a, b);
    	Integer[] t = Sorting.quicksort(tab, c);
        List<Integer> l = Arrays.asList(tab);
        l.sort(c);
        return Arrays.equals(t,l.toArray(new Integer[0]));
    }
    
    @Property
    boolean mergesortTestInteger(@ForAll("arrayInteger") Integer[] tab) {
    	Comparator<Integer> c = (Integer a,Integer b) -> Integer.compare(a, b);
    	Integer[] t = Sorting.mergesort(tab, c);
        List<Integer> l = Arrays.asList(tab);
        l.sort(c);
        return Arrays.equals(t,l.toArray(new Integer[0]));
    }
    
    @Provide
    Arbitrary<Integer[]> arrayInteger() {
    	Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 100);
    	Arbitrary<Integer[]> arrayArbitrary = integerArbitrary.array(Integer[].class).ofMinSize(0).ofMaxSize(10);
    	return arrayArbitrary;
    }
}
