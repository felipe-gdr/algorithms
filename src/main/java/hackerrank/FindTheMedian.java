package hackerrank;

import java.util.Scanner;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/find-the-median
 * 
 * @author felipereis
 *
 */
public class FindTheMedian {
	public static void findTheMedian(int[] ar, int min, int max) {
		if (min < max) {
			int pivot = partition(ar, min, max);

			findTheMedian(ar, min, pivot - 1);
			findTheMedian(ar, pivot + 1, max);
		}
	}

	public static int partition(int[] ar, int min, int max) {
		int pivot = ar[max];
		int i = min;

		for (int j = min; j < max; j++) {
			if (ar[j] < pivot) {
				swap(ar, i, j);
				i++;
			}
		}
		swap(ar, i, max);
		
        if (i == (ar.length - 1) / 2) {
			System.out.println(ar[i]);
            System.exit(0);
        }
        
        if (max == (ar.length - 1) / 2) {
			System.out.println(ar[max]);
            System.exit(0);
        }
        
		return i;
	}

	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}

		findTheMedian(ar, 0, ar.length - 1);

		in.close();
	}
	
	
	@Test
	public void testBigInput() {
		Scanner in = new Scanner(this.getClass().getResourceAsStream("input03.txt"));

		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}

		findTheMedian(ar, 0, ar.length - 1);

		in.close();
	}


}
