
package hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/game-of-stones-1
 * 
 * @author felipereis
 *
 */
public class GameOfStones {

	@Test
	public void test1Stone() {
		assertEquals("Second", new GameOfStones().solve(1));
	}

	@Test
	public void test2Stones() {
		assertEquals("First", new GameOfStones().solve(2));
	}

	@Test
	public void test3Stones() {
		assertEquals("First", new GameOfStones().solve(3));
	}

	@Test
	public void test4Stones() {
		assertEquals("First", new GameOfStones().solve(4));
	}

	@Test
	public void test5Stones() {
		assertEquals("First", new GameOfStones().solve(5));
	}

	@Test
	public void test7Stones() {
		assertEquals("Second", new GameOfStones().solve(7));
	}

	@Test
	public void test8Stones() {
		assertEquals("Second", new GameOfStones().solve(8));
	}
	
	@Test
	public void test10Stones() {
		assertEquals("First", new GameOfStones().solve(10));
	}

	public String solve(int n) {
		return new String[] { "First", "Second" }[n % 7 > 1 ? 0 : 1];
	}

}
