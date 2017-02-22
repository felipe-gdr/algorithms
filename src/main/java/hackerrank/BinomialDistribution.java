package hackerrank;

/**
 * (1) https://www.hackerrank.com/challenges/s10-binomial-distribution-1
 * (2) https://www.hackerrank.com/challenges/s10-binomial-distribution-2?h_r=next-challenge&h_v=zen
 * 
 * @author felipereis
 *
 */
public class BinomialDistribution {
    static int factorial(int num) {
        int factorial = 1;
        for (int i = num; i >= 1; i--) {
            factorial *= i;
        }

        return factorial;
    }

    static int permutation(int x, int n) {
        return factorial(n) / (factorial(x) * factorial(n - x));
    }

    static double binomialDistribution(int x, int n, double p) {
        double q = 1 - p;

        return permutation(x, n) * Math.pow(p, x) * Math.pow(q, n - x);
    }
    
    static double atLeast(int x, int n, double p) {
        double result = 0;
        
        for(int i = x; i <= n; i++) {
            result += binomialDistribution(i, n, p);
        }
        
        return result;
    }

    static double noMoreThan(int x, int n, double p) {
        double result = 0;
        
        for(int i = 0; i <= x; i++) {
            result += binomialDistribution(i, n, p);
        }
        
        return result;
    }
    
    // (1) https://www.hackerrank.com/challenges/s10-binomial-distribution-1
    public static void main1(String[] args) {
        double ratio = 1.09;
        int n = 6;
        int x = 3;
        
        double p = ratio / (1 + ratio);
        
        double result = atLeast(x, n, p);
        
        System.out.printf("%.3f", result);

    }
    
    // (2) https://www.hackerrank.com/challenges/s10-binomial-distribution-2?h_r=next-challenge&h_v=zen
    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        double p = 0.12;
        
        System.out.printf("%.3f", noMoreThan(x, n, p));
        System.out.println();
        System.out.printf("%.3f", atLeast(x, n, p));

    }
}