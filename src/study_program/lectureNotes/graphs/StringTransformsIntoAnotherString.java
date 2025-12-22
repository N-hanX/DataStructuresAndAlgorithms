package study_program.lectureNotes.graphs;

import java.util.*;

public class StringTransformsIntoAnotherString {
    public static void main(String[] args) {
//        String str1 = "aabcc";
//        String str2 = "ccdee";
//
//        String str1 = "leetcode";
//        String str2 = "codeleet";

        String str1 = "abcdefghijklmnoprstuvwxyz";
        String str2 = "bcadefghijklmnoprstuvwxzz";

        boolean result = canConvert(str1, str2);

        int a = 4;
    }

    public static boolean canConvert(String str1, String str2) {
        Map<Character, Set<Integer>> charMap = new HashMap<>();
        Map<Character, Set<Integer>> otherCharMap = new HashMap<>();

        int length = str1.length();

        for(int ind = 0; ind < length; ind++){
            char currChar = str1.charAt(ind);
            Set<Integer> charList = charMap.get(currChar);
            if(charList == null){
                charList = new HashSet<>();
                charMap.put(currChar, charList);
            }
            charList.add(ind);

            char otherChar = str2.charAt(ind);
            Set<Integer> otherCharList = otherCharMap.get(otherChar);
            if(otherCharList == null){
                otherCharList = new HashSet<>();
                otherCharMap.put(otherChar, otherCharList);
            }
            otherCharList.add(ind);
        }

        for(int ind = 0; ind < length; ind++){
            char currChar = str1.charAt(ind);
            Set<Integer> charList = charMap.get(currChar);

            char otherChar = str2.charAt(ind);
            Set<Integer> otherCharList = otherCharMap.get(otherChar);

            for(Integer charIndex:charList){
                if(!otherCharList.contains(charIndex)){
                    return false;
                }
            }
        }

        return true;
    }
}
