package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-children
 * 
 * @author felipereis
 *
 */
public class MaxMin {
	private static void maxMin(int[] ar, int k) {
		Arrays.sort(ar);

		int minimumUnfairness = Integer.MAX_VALUE;

		for (int i = 0; i <= ar.length - k; i++) {
			int min = ar[i];
			int max = ar[i + k - 1];

			if (max - min < minimumUnfairness) {
				minimumUnfairness = max - min;
			}
		}

		System.out.println(minimumUnfairness);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		maxMin(ar, k);

		in.close();
	}
}
