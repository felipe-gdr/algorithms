package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort3
 * 
 * https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme
 * 
 * @author felipereis
 *
 */
public class QuickSortPart3InPlace {
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

		printArray(ar);

		return i;
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}

		quickSortInPlace(ar, 0, ar.length - 1);

		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
