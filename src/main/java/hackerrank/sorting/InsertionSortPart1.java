package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1
 * 
 * @author felipereis
 *
 */
public class InsertionSortPart1 {
	public static void insertIntoSorted(int[] ar) {
		int unsorted = ar[ar.length - 1];
		int current = ar.length - 2;

		while (current >= 0 && ar[current] > unsorted) {
			ar[current + 1] = ar[current];
			current--;
			printArray(ar);
		}

		ar[current + 1] = unsorted;
		printArray(ar);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);

		in.close();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
