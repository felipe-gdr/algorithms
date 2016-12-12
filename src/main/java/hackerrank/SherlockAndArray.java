package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * 
 * @author felipereis
 *
 */
public class SherlockAndArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int[][] testCases = new int[t][];
		
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] ar = new int[n];

			for (int j = 0; j < n; j++) {
				ar[j] = in.nextInt();
			}

			testCases[i] = ar;
		}
		
		in.close();
		
		for(int[] testCase : testCases) {
			System.out.println(sherlockAndArray(testCase));
		}
	}

	private static String navigateLeft(int[] ar, int middle, int sumLeft, int sumRight) {
		for (int i = middle - 1; i >= 0; i--) {
			sumRight += ar[i+1];
			sumLeft -= ar[i];

			if(sumRight == sumLeft) {
				return "YES";
			} else if (sumRight > sumLeft) {
				return "NO";
			}
		}
		
		return "NO";
	}
	
	private static String navigateRight(int[] ar, int middle, int sumLeft, int sumRight) {
		int length = ar.length;

		for (int i = middle + 1; i < length; i++) {
			sumLeft += ar[i-1];
			sumRight -= ar[i];

			if(sumRight == sumLeft) {
				return "YES";
			} else if (sumLeft > sumRight) {
				return "NO";
			}
		}
		
		return "NO";
	}
	
	private static String sherlockAndArray(int[] ar) {
		int middle = ar.length / 2;
		
		int sumLeft = Arrays.stream(Arrays.copyOfRange(ar, 0, middle)).sum();
		int sumRight = Arrays.stream(Arrays.copyOfRange(ar, middle + 1, ar.length)).sum();

		if(sumLeft > sumRight) {
			return navigateLeft(ar, middle, sumLeft, sumRight);
		} else if (sumLeft < sumRight) {
			return navigateRight(ar, middle, sumLeft, sumRight);
		} else {
			return "YES";
		}
	}

	@Test
	public void testBigInput() {
		Scanner in = new Scanner(this.getClass().getResourceAsStream("sherlock-input03.txt"));
		int t = in.nextInt();

		int[][] testCases = new int[t][];
		
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] ar = new int[n];

			for (int j = 0; j < n; j++) {
				ar[j] = in.nextInt();
			}

			testCases[i] = ar;
		}
		
		in.close();
		
		for(int[] testCase : testCases) {
			System.out.println(sherlockAndArray(testCase));
		}
	}
}
