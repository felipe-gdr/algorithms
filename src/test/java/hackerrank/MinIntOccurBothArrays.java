package hackerrank;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinIntOccurBothArrays {

	@Test
	public void test1() {
		assertEquals(2, solution(new int[] { 1, 2, 3, 1 }, new int[] { 4, 4, 2, 3, 2 }));
	}

	@Test
	public void test2() {
		assertEquals(-1, solution(new int[] { 2, 1 }, new int[] { 3, 3 }));
	}

	@Test
	public void test3() {
		assertEquals(2, solution(new int[] { 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				new int[] { 4, 4, 5, 3, 9, 9, 9, 9, 2 }));
	}

	@Test
	public void test4() {
		assertEquals(10,
				solution(new int[] { 10, 20, 30, 10 }, new int[] { 4, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 2 }));
		// 10,10,20,30
		// 2 ,3 ,4 ,10
	}

	public int solution(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;

		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		for (int k = 0; k < n; k++) {
			if (i < m - 1 && B[i] < A[k] && (k-- >= -1))
				i += 1;

			if (k >= 0 && A[k] == B[i])
				return A[k];
		}
		return -1;
	}
}
