package practice.strivers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3};
//        int[] nums = new int[]{3,2,1};
//        int[] nums = new int[]{1,1,5};
//        int[] nums = new int[]{1,3,2};
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        System.out.println(Arrays.toString(getNextPermutation(new int[]{1,2,3})));
        System.out.println(Arrays.toString(getNextPermutation(new int[]{3,2,1})));
        System.out.println(Arrays.toString(getNextPermutation(new int[]{1,1,5})));
        System.out.println(Arrays.toString(getNextPermutation(new int[]{1,3,2})));
        System.out.println(Arrays.toString(getNextPermutation(nums)));
    }

    public static int[] getNextPermutation(int[] a) {
        int n = a.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = a[i];
                a[i] = a[n - 1 - i];
                a[n - 1 - i] = temp;
            }
        } else {
            for (int i = n - 1; i > index; i--) {
                if (a[i] > a[index]) {
                    int temp = a[i];
                    a[i] = a[index];
                    a[index] = temp;
                    break;
                }
            }

            int j = n-1;
            int i = index + 1;
            while (j > i) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
                i++;
            }
        }
        return a;
    }
}
