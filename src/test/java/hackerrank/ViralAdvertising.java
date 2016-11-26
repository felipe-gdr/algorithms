package hackerrank;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/strange-advertising?h_r=next-challenge&
 * h_v=zen
 * 
 * @author felipereis
 *
 */
public class ViralAdvertising {

	@Test
	public void testExample() {
		assertEquals(9, new ViralAdvertising().solve(3));
	}

	@Test
	public void testExampleNoArray() {
		assertEquals(9, new ViralAdvertising().solveWihoutArrayList(3));
	}

	public int solve(int n) {
		List<Integer> days = new ArrayList<>();

		days.add(5);

		for (int d = 1; d <= n; d++) {
			int liked = (days.get(d - 1) / 2);
			days.add(liked * 3);
			days.set(d - 1, liked);
		}

		return days.stream().limit(n).reduce(0, (x, y) -> x + y);
	}

	public int solveWihoutArrayList(int n) {
		int shared = 5;
		int totalOpened = 0;

		for (int d = 1; d <= n; d++) {
			int opened = shared / 2;
			totalOpened += opened;
			shared = opened * 3;
		}

		return totalOpened;
	}
}
