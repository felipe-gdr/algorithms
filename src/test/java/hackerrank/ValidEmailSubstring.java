package hackerrank;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ValidEmailSubstring {

	@Test
	public void test1() {
		assertEquals(2, solution("a0Ba"));
	}

	@Test
	public void test2() {
		assertEquals(-1, solution("a0bb"));
	}

	@Test
	public void test3() {
		assertEquals(4, solution("00b0A91Dn1n0sf1AAv0aSdf0B"));
	}

	public int solution(String s) {
		final int sLength = s.length();

		// Creates a list with all possible substrings
		List<String> allSubs = new ArrayList<>();
		for (int i = 0; i < sLength; i++) {
			for (int j = i + 1; j <= sLength; j++) {
				allSubs.add(s.substring(i, j));
			}
		}

		// Sorts by length
		allSubs.sort((s1, s2) -> Integer.valueOf(s2.length()).compareTo(s1.length()));

		for (String sub : allSubs) {
			// Could have used smarter regex, this is not looking good yet
			if (sub.matches(".*[A-Z]+.*") && !sub.matches(".*\\d+.*")) {
				// As soon as we find a match, we return its length
				return sub.length();
			}
		}

		return -1;
	}
}
