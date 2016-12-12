package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort1
 * 
 * @author felipereis
 *
 */
public class CountingSortPart1 {
	public static int[] countElements(int[] ar) {
		int[] counts = new int[100];

		for (int i : ar) {
			counts[i] += 1;
		}

		return counts;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		in.close();

		printArray(countElements(ar));
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
