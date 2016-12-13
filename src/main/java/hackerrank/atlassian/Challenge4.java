package hackerrank.atlassian;

import java.util.Scanner;

public class Challenge4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String commands = in.next();

		run(commands);

		in.close();
	}

	private static void run(String commands) {
		String[] arr = commands.split("P");

		int[] rows = new int[10];

		for (String c : arr) {
			if (c.endsWith("L")) {
				int movements = countOccurences(c, "M");

				rows[movements]++;
			}
		}
		
		print(rows);

	}

	private static void print(int[] rows) {
		StringBuilder sb = new StringBuilder();
		for (int c : rows) {
			
			if(c > 15) c = 15;
			
			String hex = Integer.toHexString(c);
			
			sb.append(hex);
		}
		
		System.out.println(sb.toString().toUpperCase());

	}

	private static int countOccurences(String str, String character) {
		return str.length() - str.replace(character, "").length();
	}
}
