package hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * There are two kangaroos on an x-axis ready to jump in the positive direction
 * (i.e, toward positive infinity). The first kangaroo starts at location x1 and
 * moves at a rate of v1 meters per jump. The second kangaroo starts at location
 * x2 and moves at a rate of v2 meters per jump. Given the starting locations
 * and movement rates for each kangaroo, can you determine if they'll ever land
 * at the same location at the same time?
 * 
 * @author felipereis
 *
 */
public class Kangaroo {

	@Test
	public void testExample() {
		assertEquals("YES", new Kangaroo().solve(0, 3, 4, 2));
	}

	public String solve(int x1, int v1, int x2, int v2) {
		int d1 = x1;
		int d2 = x2;

		while (d1 < d2) {
			d1 += v1;
			d2 += v2;
		}

		return d1 == d2 ? "YES" : "NO";
	}

}
