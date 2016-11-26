package codility;

import java.util.Arrays;

public class Equi {

	public static void main(String[] args) {
		int[] array = { -1, 3, -4, 5, 1, -6, 2, 1 };

		new Equi().solution(array);
	}

	public int solution(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int sumLeft =  Arrays.stream(Arrays.copyOfRange(A, i+1, A.length)).sum();
			int sumRight = Arrays.stream(Arrays.copyOfRange(A, 0, i)).sum();
			
			if(sumLeft == sumRight) {
				return i;				
			}
		}

		return -1;
	}

}
