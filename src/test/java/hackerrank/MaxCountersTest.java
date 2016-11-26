package hackerrank;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.OptionalInt;

import org.junit.Test;

public class MaxCountersTest {

	@Test
	public void test() {
		assertArrayEquals(new int[] { 3, 2, 2, 4, 2 },
				new MaxCountersTest().solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }));
	}

	public int[] solution(int N, int[] A) {
		final int[] counters = new int[N];

		// fill with zeroes
		Arrays.fill(counters, 0);

		for (int i = 0; i < A.length; i++) {
			int x = A[i];

			if (x >= 1 && x <= N) {
				// increase specific counter
				counters[x-1] = counters[x-1] + 1;
			} else if (x == N + 1) {
				// find max
				OptionalInt highest = Arrays.stream(counters).max();
				// set highest value to all counters
				Arrays.fill(counters, highest.getAsInt());
			}
		}
		
		return counters;
	}
}
