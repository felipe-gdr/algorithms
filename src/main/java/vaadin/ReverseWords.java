package vaadin;

import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		char[] str = "Java is nice!".toCharArray();
		char[] goal = "nice! is Java".toCharArray();

		System.out.println("Original: '" + new String(str) + "'");

		reverse(str);

		boolean success = new String(str).equals(new String(goal));
		System.out.println("Reversed: '" + new String(str) + "'\n\nReverse " + (success ? "succeeded." : "failed!"));
	} 
	
	private static void reverse(char[] s) {
		int length = s.length;
		// Invert all characters
		for (int i = 0; i < length / 2; i++) {
			char temp = s[i];
			s[i] = s[length - 1 - i];
			s[length - 1 - i] = temp;
		}
		
		for (int i = 0; i < length; i++) {
			int j = i;

			while (j < length && s[j] != ' ') {
				j++;
			}

			int wordLength = j - i;
			for(int k = 0; k < wordLength / 2; k++) {
				char temp1 = s[k + i];
				char temp2 = s[i+wordLength-k-1];
				s[k+i] = temp2;
				s[i+wordLength-k-1] = temp1;
			}
			
			i = j;

		}

		System.out.println(Arrays.toString(s));
		
		// List<char[]> result = new ArrayList<>();
		//
		// for (int i = s.length - 1; i >= 0; i--) {
		// int j = i - 1;
		//
		// while (j > -1 && s[j] != ' ')
		// j--;
		//
		// result.add(Arrays.copyOfRange(s, j + 1, i + 1));
		//
		// i = j;
		// }
		//
		// int totalCopied = 0;
		// for (int i = 0; i < result.size(); i++) {
		// char[] c = result.get(i);
		//
		// System.arraycopy(c, 0, s, totalCopied, c.length);
		//
		// totalCopied += c.length;
		//
		// if (i != result.size() - 1) {
		// s[totalCopied] = ' ';
		// totalCopied++;
		// }
		// }
	}

}
