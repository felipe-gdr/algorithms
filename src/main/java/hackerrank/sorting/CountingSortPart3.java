package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort3
 * 
 * @author felipereis
 *
 */
public class CountingSortPart3 {
	private static final int range = 100;

	public static int[] countElements(int[] ar) {
		int[] counts = new int[range];

		for (int i : ar) {
			counts[i] += 1;
		}

		return counts;
	}

	public static int[] countLessOrEqual(int[] numbers) {
		int[] counts = countElements(numbers);
		int[] countLessOrEqual = new int[counts.length];
		int accumulated = 0;

		for (int i = 0; i < counts.length; i++) {
			int c = counts[i];
			accumulated += c;
			countLessOrEqual[i] = accumulated;
		}

		return countLessOrEqual;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();

		int[] numbers = new int[s];
		String[] strings = new String[s];

		for (int i = 0; i < s; i++) {
			numbers[i] = in.nextInt();
			strings[i] = in.next();
		}
		in.close();

		printArray(countLessOrEqual(numbers));
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
