package hackerrank.atlassian;

import java.util.Scanner;

public class Challenge2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String start = in.next();
		int n = in.nextInt();

		run(start, n);

		in.close();
	}

	private static int[] splitDigits(String num) {
		String[] str = num.split("");

		int[] digits = new int[str.length];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = Integer.valueOf(str[i]);
		}

		return digits;
	}

	private static void run(String start, int n) {
		int[] digits = splitDigits(start);

		String result = lookAndSay(digits);

		while (n > 1) {
			result = lookAndSay(splitDigits(result));

			n--;
		}

		System.out.println(result);

	}

	private static String lookAndSay(int[] digits) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < digits.length; i++) {
			int count = 1;
			while (i < digits.length - 1 && digits[i + 1] == digits[i]) {
				count++;
				i++;
			}

			sb.append(String.format("%d%d", count, digits[i]));

		}

		return sb.toString();
	}

}
