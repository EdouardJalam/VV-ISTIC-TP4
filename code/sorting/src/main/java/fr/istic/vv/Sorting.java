package fr.istic.vv;
import java.util.Comparator;
import java.util.Arrays;

public class Sorting {

    public static <T> T[] bubblesort(T[] array, Comparator<T> comparator) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (comparator.compare(array[j], array[j + 1]) > 0) {
					T tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		return array;
	}

	private static <T> int partition(T array[], Comparator<T> comparator, int begin, int end) {
		T pivot = array[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (comparator.compare(array[j], pivot) <= 0) {
				i++;

				T swapTmp = array[i];
				array[i] = array[j];
				array[j] = swapTmp;
			}
		}

		T swapTmp = array[i + 1];
		array[i + 1] = array[end];
		array[end] = swapTmp;

		return i + 1;
	}

	private static <T> void quicksortAux(T[] array, Comparator<T> comparator, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(array, comparator, begin, end);

			quicksortAux(array, comparator, begin, partitionIndex - 1);
			quicksortAux(array, comparator, partitionIndex + 1, end);
		}
	}

	public static <T> T[] quicksort(T[] array, Comparator<T> comparator) {
		quicksortAux(array, comparator, 0, array.length - 1);
		return array;
	}

	private static <T> void merge(T[] a, T[] l, T[] r, int left, int right, Comparator<T> comparator) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (comparator.compare(l[i], r[j]) <= 0) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

	private static <T> void mergesortAux(T[] a, int n, Comparator<T> comparator) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		T[] l = Arrays.copyOf(a, mid);
		T[] r = Arrays.copyOfRange(a, mid, n);

		mergesortAux(l, mid, comparator);
		mergesortAux(r, n - mid, comparator);

		merge(a, l, r, mid, n - mid, comparator);
	}

	public static <T> T[] mergesort(T[] array, Comparator<T> comparator) {
		mergesortAux(array, array.length, comparator);
		return array;
	}

}
