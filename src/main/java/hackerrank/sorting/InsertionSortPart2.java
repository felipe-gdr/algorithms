package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort2
 * 
 * <p>
 * Sample input: <code>
 * 6
 * 1 4 3 5 6 2
 * </code> <br>
 * Sample output: <code>
 * 1 4 3 5 6 2 
 * 1 3 4 5 6 2 
 * 1 3 4 5 6 2 
 * 1 3 4 5 6 2 
 * 1 2 3 4 5 6 
 * </code>
 * </p>
 * 
 * @author felipereis
 *
 */
public class InsertionSortPart2 {
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
		}

		ar[current + 1] = unsorted;
		printArray(ar);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
