package practice.scaler.day9;

import java.util.Arrays;

public class ProductArrayPuzzle {
    public static void main(String[] args) {
//        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] A = new int[]{5,1,10,1};
        int[] solve = solve(A);
        for (int i = 0; i < solve.length; i++) {
            System.out.println(solve[i]);
        }

    }

    public static int[] solve(int[] A) {
        int[] prefix = new int[A.length];
        int[] sufix = new int[A.length];
        int[] result = new int[A.length];
        int n = A.length;
        prefix[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * A[i];
        }
        sufix[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufix[i] = sufix[i + 1] * A[i];
        }
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                result[i] = sufix[i];
            } else if (i == n - 1) {
                result[i] = prefix[i-1];
            } else {
                result[i] = prefix[i-1] * sufix[i+1];
            }
        }
        return result;
    }
}
