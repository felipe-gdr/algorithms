package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort4
 * 
 * 
 * @author felipereis
 *
 */
public class QuickSortPart4RunningTime {
	/* Insertion sort */
	private static int insertionSwapCount = 0;

	public static void insertionSortPart2(int[] ar) {
		for (int i = 1; i < ar.length; i++) {
			placeElement(ar, i);
		}
	}

	public static void placeElement(int[] ar, int index) {
		int unsorted = ar[index];
		int current = index - 1;

		while (current >= 0 && ar[current] > unsorted) {
			ar[current + 1] = ar[current];
			current--;
			insertionSwapCount++;
		}

		ar[current + 1] = unsorted;
	}

	/* Quick sort */
	public static void quickSortInPlace(int[] ar, int min, int max) {
		if (min < max) {
			int pivot = partition(ar, min, max);

			quickSortInPlace(ar, min, pivot - 1);
			quickSortInPlace(ar, pivot + 1, max);
		}
	}

	public static int partition(int[] ar, int min, int max) {
		int pivot = ar[max];
		int i = min;

		for (int j = min; j < max; j++) {
			if (ar[j] < pivot) {
				swap(ar, i, j);
				i++;
			}
		}
		swap(ar, i, max);

		return i;
	}

	private static int quickSwapCount = 0;

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

		quickSwapCount++;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		in.close();

		quickSortInPlace(Arrays.copyOf(ar, s), 0, ar.length - 1);
		insertionSortPart2(Arrays.copyOf(ar, s));

		System.out.println(insertionSwapCount - quickSwapCount);
	}
}
