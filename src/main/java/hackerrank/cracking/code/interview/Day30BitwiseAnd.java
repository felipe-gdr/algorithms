package hackerrank.cracking.code.interview;

import java.util.Scanner;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/30-bitwise-and
 * 
 * @author felipereis
 *
 */
public class Day30BitwiseAnd {
    private static void run(int n, int k) {
        int highest = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int result = i & j;

                if (result > highest && result < k) {
                    highest = result;
                }
            }
        }

        System.out.println(highest);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[][] ar = new int[t][2];

        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();

            ar[a0] = new int[] { n, k };
        }

        for (int[] pair : ar) {
            run(pair[0], pair[1]);
        }

        in.close();
    }

    @Test
    public void tests() {
        int i = 100;
        int j = 200;

        System.err.println(i & j);
    }
}
