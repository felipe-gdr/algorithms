package hackerrank;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class AppleAndOrange {

	@Test
	public void testExample() {
		assertArrayEquals(new int[] { 1, 1 }, solve(7, 11, 5, 15, new int[] { -2, 2, 1 }, new int[] { 5, -6 }));
	}

	@Test
	public void testCornerCase1() {
		assertArrayEquals(new int[] { 3, 6 },
				solve(7, 11, 5, 15, new int[] { 0, -2, 2, 1, 3, 6 }, new int[] { 5, -6, -7, -4, -4, -4, -4, -10 }));
	}

	public int[] solve(int s, int t, int a, int b, int[] apples, int[] oranges) {
		final int[] result = new int[] { 0, 0 };
		final int[][] fruits = new int[][] { apples, oranges };
		final int[] trees = new int[] { a, b };

		for (int x = 0; x < trees.length; x++) {
			int[] thisFruit = fruits[x];

			for (int fruit : thisFruit) {
				int drop = fruit + trees[x];
				if (drop >= s && drop <= t) {
					result[x] = result[x] + 1;
				}
			}
		}

		return result;
	}

}
