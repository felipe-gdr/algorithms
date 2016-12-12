package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pairs
 * 
 * @author felipereis
 *
 */
public class Pairs {
	private static void findPairs(int[] ar, int k) {
		Arrays.sort(ar);

		int result = 0;

		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				int diff = ar[j] - ar[i];

				if (diff == k) {
					result++;
				} else if (diff > k) {
					break;
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}

		findPairs(ar, k);

		in.close();
	}
}
