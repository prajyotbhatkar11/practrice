package practice.neetcode.arrays;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s ="racecar";
        String t = "carrace";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        for (int i =0 ; i< s.length(); i++){
            if (charCount.containsKey(s.charAt(i))){

            }
        }
        return false;
    }
}
