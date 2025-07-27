package practice.strivers;

import java.util.Arrays;

public class MaxProfit {
    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{3,2,6,5,0,3};
//        int[] prices = new int[]{7,6,4,3,1};
//        int[] prices = new int[]{2, 4, 1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(new int[]{2, 4, 1}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitOptimal(new int[]{7, 1, 5, 3, 6, 4}));
//    System.out.println(Arrays.deepToString(setMatrixZeroOptimal(matrix)));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0], result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = min;
            } else if (max < prices[i]) {
                max = prices[i];
                result = Math.max(result, max - min);
            }
        }
        if (prices[prices.length - 1] == min) {
            return result;
        } else if (min == max) {
            return 0;
        } else {
            return result;
        }
    }

    public static int maxProfitOptimal(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i : prices){
            min = i < min ? i : min;
            int diff = i - min;
            if(diff > maxProfit){
                maxProfit = diff;
            }
        }
        return maxProfit;
    }
}
