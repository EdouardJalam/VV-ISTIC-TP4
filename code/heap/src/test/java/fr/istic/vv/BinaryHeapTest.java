package fr.istic.vv;
import net.jqwik.api.*;
import java.util.Comparator;

public class BinaryHeapTest {
    @Property
    <T> boolean heapTest(@ForAll("multipleBinaryHeap") BinaryHeap<T> heap) {
    	T last = heap.pop();
    	while(heap.count() > 0) {
        	if(heap.getComparator().compare(last, last=heap.pop()) > 0) return false;
        }
    	return true;
    }
    
    @Provide
	Arbitrary<BinaryHeap<Integer>> multipleBinaryHeap() {
    	Comparator<Integer> cInt = (Integer a,Integer b) -> Integer.compare(a, b);
    	Arbitrary<Integer> ints = Arbitraries.integers().between(0, 100);
		return Arbitraries.integers().between(0, 10).map(i -> {
			BinaryHeap<Integer> heap = new BinaryHeap<Integer>(cInt);
			ints.forEachValue(val -> heap.push(val));
			return heap;
			});
	}
}
