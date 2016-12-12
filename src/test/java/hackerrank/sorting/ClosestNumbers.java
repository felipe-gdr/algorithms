package hackerrank.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/closest-numbers
 * 
 * @author felipereis
 *
 */
public class ClosestNumbers {
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

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	private static Integer[] closestNumbers(int[] ar) {
		List<Integer> result = new ArrayList<>();
		int smallestDifference = Integer.MAX_VALUE;

		for (int i = 0; i < ar.length - 1; i++) {
			int a = ar[i];
			int b = ar[i + 1];
			int diff = Math.abs(a - b);

			if (diff < smallestDifference) {
				smallestDifference = Math.abs(a - b);
				result.clear();
			}

			if (diff <= smallestDifference) {
				result.addAll(Arrays.asList(a, b));
			}
		}

		return result.toArray(new Integer[result.size()]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}

		quickSortInPlace(ar, 0, ar.length - 1);

		printArray(closestNumbers(ar));

		in.close();
	}

	private static void printArray(Integer[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
