package hackerrank.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort2
 * 
 * 
 * @author felipereis
 *
 */
public class QuickSortPart2 {
	public static List<Integer> quickSortPart2(List<Integer> ar) {
		Map<Integer, List<Integer>> splits = partition(ar);

		if (splits.get(-1).size() >= 2) {
			splits.put(-1, quickSortPart2(splits.get(-1)));
		}

		if (splits.get(1).size() >= 2) {
			splits.put(1, quickSortPart2(splits.get(1)));
		}

		List<Integer> sorted = new ArrayList<>();
		sorted.addAll(splits.get(-1));
		sorted.addAll(splits.get(0));
		sorted.addAll(splits.get(1));

		printArray(sorted);

		return sorted;
	}

	public static Map<Integer, List<Integer>> partition(List<Integer> ar) {
		Map<Integer, List<Integer>> splits = new HashMap<>();
		// left
		splits.put(-1, new ArrayList<>());
		// equals
		splits.put(0, new ArrayList<>());
		// right
		splits.put(1, new ArrayList<>());

		final Integer p = ar.get(0);

		for (int i = 0; i < ar.size(); i++) {
			splits.get(p.compareTo(ar.get(i)) * -1).add(ar.get(i));
		}

		return splits;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		Integer[] ar = new Integer[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}

		quickSortPart2(Arrays.asList(ar));

		in.close();
	}

	private static void printArray(List<Integer> ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
