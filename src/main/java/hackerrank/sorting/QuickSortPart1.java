package hackerrank.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort1
 * 
 * 
 * @author felipereis
 *
 */
public class QuickSortPart1 {
	public static void quickSortPart1(int[] ar) {
		Map<Integer, List<Integer>> splits = new HashMap<>();
		// left
		splits.put(-1, new ArrayList<>());
		// equals
		splits.put(0, new ArrayList<>());
		// right
		splits.put(1, new ArrayList<>());

		final Integer p = ar[0];

		for (int i = 0; i < ar.length; i++) {
			splits.get(p.compareTo(ar[i]) * -1).add(ar[i]);
		}

		// creates final array
		List<Integer> result = splits.get(-1);
		result.addAll(splits.get(0));
		result.addAll(splits.get(1));

		printArray(result.toArray(new Integer[result.size()]));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		quickSortPart1(ar);

		in.close();
	}

	private static void printArray(Integer[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
