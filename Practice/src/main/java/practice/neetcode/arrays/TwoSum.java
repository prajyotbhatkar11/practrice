package practice.neetcode.arrays;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] A = new int[]{3,4,5,6};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(A, target)));
//        Collections.singletonList(twoSum(A, target)).forEach(System.out::println);
    }

    public static int [] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        for (int i =0; i< nums.length; i++){
            if (sumMap.containsKey(nums[i]) || sumMap.containsKey(target-nums[i])){
                result[1] = i;
                result[0]= sumMap.get(target-nums[i]);
            }else {
                sumMap.put(nums[i],i);
            }
        }
        return result;
    }
}
