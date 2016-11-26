package hackerrank.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/countingsort4
 * 
 * @author felipereis
 *
 */
public class CountingSortPart4 {
	public static int[] countElements(int[] ar) {
		int[] counts = new int[Arrays.stream(ar).max().getAsInt() + 1];

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

	public static String[] sortStringsWithATwist(int[] numbers, String[] strings) {
		final int length = numbers.length;
		final int[] countLessOrEqual = countLessOrEqual(numbers);
		final int[] countInserted = new int[countLessOrEqual.length];

		final String[] sortedStrings = new String[length];

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];

			int initialPosition = number == 0 ? 0 : countLessOrEqual[number - 1];

			if (i < (length + 1) / 2) {
				sortedStrings[initialPosition + countInserted[number]] = "-";
			} else {
				sortedStrings[initialPosition + countInserted[number]] = strings[i];
			}

			countInserted[number]++;

		}

		return sortedStrings;

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

		printArray(sortStringsWithATwist(numbers, strings));
	}

	private static void printArray(String[] ar) {
		StringBuilder sb = new StringBuilder();
		for (String n : ar) {
			sb.append(n).append(" ");
		}
		System.out.println(sb.toString());
	}

	@Test
	public void testWithBigInput() throws FileNotFoundException {
		Scanner in = new Scanner(new File(CountingSortPart4.class.getResource("input05.txt").getFile()));
		int s = in.nextInt();

		int[] numbers = new int[s];
		String[] strings = new String[s];

		for (int i = 0; i < s; i++) {
			numbers[i] = in.nextInt();
			strings[i] = in.next();
		}
		in.close();

		printArray(sortStringsWithATwist(numbers, strings));
	}

}
