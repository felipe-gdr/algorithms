package hackerrank;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SmallestSum {
	// public static void main(String[] args) {
	// // int[] chain = new int[] { 7, 10, 12, 220, 1, 2, 3, 9, 6, 4, 7 };
	//
	//
	//
	// int[] chain = new int[] { 7, 10, 12, 220, 1, 2, 3, 9, 6, 4, 7, -2, -4, -5
	// };
	//
	// System.out.println(smallestSum(chain)); // What should this print?
	// }

	@Test
	public void testStandardCase() {
		int[] chain = new int[] { 7, 10, 12, 220, 1, 2, 3, 9, 6, 4, 7 };

		long result = new SmallestSum().smallestSum(chain);

		Assert.assertEquals(3, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithNegative() {
		int[] chain = new int[] { 7, 10, 12, 220, 1, -10, 2, 3, 9, 6, 4, 7 };

		new SmallestSum().smallestSum(chain);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithEmptyArray() {
		int[] chain = new int[] {};

		new SmallestSum().smallestSum(chain);
	}

	@Test(expected = NullPointerException.class)
	public void testWithNullArray() {
		int[] chain = null;

		new SmallestSum().smallestSum(chain);
	}

	@Test
	public void testWithVeryLargeNumbers() {
		int[] chain = { Integer.MAX_VALUE - 4, Integer.MAX_VALUE - 5, 20 };

		long result = new SmallestSum().smallestSum(chain);

		Assert.assertEquals((long) Integer.MAX_VALUE + 15, result);
	}

	public long smallestSum(int[] array) {
		if (array.length < 2) {
			throw new IllegalArgumentException("Array needs to have at least 2 numbers");
		}

		if (Arrays.stream(array).min().getAsInt() <= 0) {
			throw new IllegalArgumentException("Array cannot have negative numbers or zeroes");
		}

		return Arrays.stream(array).sorted().limit(2).asLongStream().sum();
	}

}
