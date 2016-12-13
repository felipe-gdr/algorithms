package hackerrank.atlassian;

import java.util.Scanner;

/*
 * Complete the function that takes an integer as its argument   
 * and returns the encoded string in base 7 using the following encoding rule: 
 * base 10 0 1 2 3 4 5 6 base 7 0 a t l s i N 
 * Sample Input 1 7 
 * Sample Output 1 a0 
 */
public class EncodeString {
	public static void main(String[] args) {

		char[] base = { '0', 'a', 't', 'l', 's', 'i', 'n' };

		Scanner in = new Scanner(System.in);
		long t = in.nextLong();

		long i = t;

		if (i == 0) {
			System.out.println("0");
		}

		StringBuffer sb = new StringBuffer();
		while (i > 0) {
			long m = i % base.length;
			
			
			sb.append(base[(int) m]);
			i = i / base.length;
		}

		System.out.println(sb.reverse());
		in.close();

	}
}
