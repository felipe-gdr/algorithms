package usp.algoritmos.java;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        coutingSort(new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 3, 3 });
    }

    static void coutingSort(int[] numeros) {
        int[] aux = new int[3];

        for (int i = 0; i < numeros.length; i++) {
            int num = numeros[i];

            aux[num-1]++;
        }

        System.out.println(Arrays.toString(aux));
        
        int a = aux[0];
        
        for (int i = 0; i < a; i++) {
            numeros[i] = a;
        }

        System.out.println(Arrays.toString(numeros));

    }
}
