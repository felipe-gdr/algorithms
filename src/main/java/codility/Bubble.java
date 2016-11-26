package codility;

public class Bubble {
	// Bubble sort is a simple sorting algorithm that works by repeatedly
	// stepping through the list to be sorted, comparing each pair of adjacent
	// items and swapping them if they are in the wrong order. Implement the
	// algorithm.
	public static void main(String[] args) {
		final int[] input = new int[] { 1, 3, 4, 6, 8, 4, 2, 1, 5, 1 };
		int[] sorted = bubbleSort(input);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}

	public static int[] bubbleSort(int[] ar) {
		int length = ar.length;

		for (int i = 0; i < length; i++) {
			loop(ar);
		}

		return ar;
	}

	public static void loop(int[] ar) {
		int length = ar.length;
		for (int i = 0; i < length - 1; i++) {
			int a = ar[i];
			int b = ar[i + 1];

			if (a > b) {
				ar[i + 1] = a;
				ar[i] = b;
			}
		}
	}

}
