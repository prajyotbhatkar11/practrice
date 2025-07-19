package practice.neetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
//        int[] A = new int[]{2, 4, 1, 3, 2};
        int[] A = new int[]{731,349,490,781,271,405,811,181,102,126,866,16,622,492,194,735};
        System.out.println(hasDuplicate(A));
    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set= new HashSet<Integer>();

        for(int i =0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
