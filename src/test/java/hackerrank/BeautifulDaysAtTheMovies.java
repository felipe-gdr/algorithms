package hackerrank;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class BeautifulDaysAtTheMovies {

	@Test
	public void simpleCase() {
		Assert.assertEquals(2, solve(20, 23, 6));
	}

	int result = 0;

	public int solve(int i, int j, int k) {
		result = 0;

		IntStream.range(i, j + 1).forEach(x -> {
			int xRev = Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());

			if (Math.abs(x - xRev) % k == 0) {
				result++;
			}

		});

		return result;
	}

}
