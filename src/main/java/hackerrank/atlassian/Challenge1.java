package hackerrank.atlassian;

import java.util.Scanner;

public class Challenge1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n1 = in.nextLong();

		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < n1; i++) {
			sb1.append(in.next());
		}

		long n2 = in.nextLong();

		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < n2; i++) {
			sb2.append(in.next());
		}

		run(sb1.toString(), sb2.toString());

		in.close();
	}

	private static void run(String ar1Str, String ar2Str) {
		System.out.println(ar1Str.indexOf(ar2Str));
	}
}
