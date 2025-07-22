package practice.neetcode.arrays;

import java.util.HashMap;
import java.util.Optional;

public class ValidAnagram {
    public static void main(String[] args) {
        String s ="bbcc";
        String t = "ccbc";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramEasy(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        if (s.length() != t.length()){
            return false;
        }
        for (int i =0 ; i< s.length(); i++){
            if (charCount.containsKey(s.charAt(i))){
                charCount.put(s.charAt(i),charCount.get(s.charAt(i))+1);
            }else {
                charCount.put(s.charAt(i),1);
            }
        }

        for (int i =0; i<t.length(); i++){
            if (charCount.containsKey(t.charAt(i)) && charCount.get(t.charAt(i))> -1){
                charCount.put(t.charAt(i),charCount.get(t.charAt(i))-1);
            }
            else {
                return false;
            }
        }
        long count = charCount.values()
                .stream()
                .filter(x -> x != 0)
                .count();
        if (count > 0){
            return false;
        }
        return true;
    }

    public static boolean isAnagramEasy(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}
