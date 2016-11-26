package codility;

public class FibonnaciAverage {
	// {1, 1, 2, 3, 5, 8...}
	public static void main(String[] args) {
		System.out.println(fibonacciAverage(5)); // What should this print?
		System.out.println(fibonacciAverage(1)); // What should this print?
	}

	private static double fibonacciAverage(int i) {
		int n_2 = 0;
		int n_1 = 1;

		double total = n_1;

		for (int x = 1; x < i; x++) {
			int n = n_2 + n_1;

			n_2 = n_1;
			n_1 = n;

			total += n;
		}

		return total / i;
	}
}
