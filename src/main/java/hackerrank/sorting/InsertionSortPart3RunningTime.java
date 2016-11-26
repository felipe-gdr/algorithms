package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/runningtime
 * 
 * @author felipereis
 *
 */
public class InsertionSortPart3RunningTime {
	private static int shifCount = 0;

	public static void insertionSortPart2(int[] ar) {
		shifCount = 0;
		for (int i = 1; i < ar.length; i++) {
			placeElement(ar, i);
		}

		System.out.println(shifCount);
	}

	public static void placeElement(int[] ar, int index) {
		int unsorted = ar[index];
		int current = index - 1;

		while (current >= 0 && ar[current] > unsorted) {
			ar[current + 1] = ar[current];
			current--;
			shifCount++;
		}

		ar[current + 1] = unsorted;
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
}
