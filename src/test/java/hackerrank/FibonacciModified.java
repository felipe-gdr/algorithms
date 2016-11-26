package hackerrank;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * 
 * @author felipereis
 *
 */
public class FibonacciModified {

	@Test
	public void testExample() {
		assertEquals("5", new FibonacciModified().solve(0, 1, 5));
	}

	@Test
	public void largeNumbers() {
		assertEquals("84266613096281243382112", new FibonacciModified().solve(0, 1, 10));
	}

	public String solve(int t1, int t2, int n) {
		BigInteger fibo[] = new BigInteger[] { BigInteger.valueOf(t1), BigInteger.valueOf(t2),
				BigInteger.valueOf(t1 + t2 * t2) };

		for (int i = 0; i < n - 3; i++) {
			fibo[0] = fibo[1];
			fibo[1] = fibo[2];
			fibo[2] = fibo[0].add(fibo[1].multiply(fibo[1]));
		}

		return String.valueOf(fibo[2]);
	}
}
