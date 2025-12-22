package study_lc.study4_c;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubsequence_516 {
    public static void main(String[] args) {
//        String s = "bbbab";
        String s= "cbbd";
        int result = longestPalindromeSubseq(s);
        int a = 8;

    }
    public static int longestPalindromeSubseq(String s) {
        max_result = 0;
        visited = new HashSet<>();
        helper_2(new StringBuilder(s));
        return max_result;
    }

    static int max_result;
    static Set<String> visited;

    public static  void helper_2(StringBuilder currBuilder){
        String currString = currBuilder.toString();
        // System.out.println("curr_str: " + currString);
        if(visited.contains(currString)){
            return;
        }

        visited.add(currString);

        if(max_result < currBuilder.length() && isPalindrome(currString)){
            // System.out.println("true palindrome: " + currBuilder);

            max_result = currBuilder.length();
            return;
        }

        for(int i = 0; i < currBuilder.length(); i++){
            StringBuilder tempBuilder = new StringBuilder(currString);
            tempBuilder.deleteCharAt(i);
            // System.out.println("temp:" + tempBuilder.toString());
            helper_2(tempBuilder);
            // System.out.println("CURR:" + currBuilder.toString());
            // System.out.println("DONUS");
        }

    }

    // public void helper(StringBuilder originalBuilder, int running_index, String s){

    //     int left_possible_num_of_index = s.length() - running_index;
    //     int possibleMaxLen = currBuilder.length() + left_possible_num_of_index;
    //     if(possibleMaxLen < max_result){
    //         return;
    //     }


    //     String currStr = currBuilder.toString();
    //     if(visited.contains(currBuilder.toString())){
    //         return;
    //     }

    //     System.out.println("curr builder: " + currStr);

    //     if(s.length() <= running_index){
    //         if(max_result < currStr.length() && isPalindrome(currStr)){
    //             System.out.println("true palindrome: " + currStr);

    //             max_result = currBuilder.length();
    //         }
    //         visited.add(currStr);
    //         return;
    //     }


    //     char curr_char = s.charAt(running_index);
    //     // include curr char
    //     StringBuilder tempBuilder = new StringBuilder(currBuilder);
    //     tempBuilder.deleteCharAt(running_index);
    //     helper(currBuilder, running_index + 1, s);
    //     helper(tempBuilder, running_index + 1, s);
    // }

    public static boolean isPalindrome(String s){
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        // System.out.println("check palindrome: " + s);

        while(s.length() > 0 && leftPointer <= rightPointer){
            // System.out.println("left: " + s.charAt(leftPointer));
            // System.out.println("right: " + s.charAt(rightPointer));
            if(s.charAt(leftPointer) == s.charAt(rightPointer)){
                leftPointer++;
                rightPointer--;
            }else{
                // System.out.println("false palindrom: " + s);
                return false;
            }
        }
        return true;
    }
}
