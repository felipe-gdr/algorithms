package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort2
 * 
 * @author felipereis
 *
 */
public class CountingSortPart2 {
	private static final int range = 100;

	public static int[] countElements(int[] ar) {
		int[] counts = new int[range];

		for (int i : ar) {
			counts[i] += 1;
		}

		return counts;
	}

	public static int[] sort(int[] ar) {
		int[] counts = countElements(ar);

		int[] sorted = new int[ar.length];

		int countIdx = 0;
		for (int i = 0; i < range; i++) {
			int c = counts[i];
			for (int j = 0; j < c; j++) {
				sorted[countIdx] = i;
				countIdx++;
			}
		}

		return sorted;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		in.close();

		printArray(sort(ar));
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
