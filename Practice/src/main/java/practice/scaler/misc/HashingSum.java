package practice.scaler.misc;

import java.util.HashMap;
import java.util.Objects;

public class HashingSum {
    public static void main(String[] args) {
//        int[] A = new int[]{2, 4, 1, 3, 2};
        int[] A = new int[]{8,9,1,-2,4,5,11,-6,7,5};
        System.out.println(findIndex(A, 22));
    }

    public static boolean findIndex(int[] nums, int k) {
       HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            if(!integerHashMap.containsKey(nums[i])){
                integerHashMap.put(nums[i],i);
            }
        }

        for (int i = 0; i <nums.length;i++){
            if(integerHashMap.containsKey(k - nums[i])){
                System.out.println(integerHashMap.get(k - nums[i]) +","+ integerHashMap.get(nums[i]));
                if (!Objects.equals(integerHashMap.get(k - nums[i]), integerHashMap.get(nums[i]))) {
                    return true;
                }
            }
        }
        return false;
    }
}
