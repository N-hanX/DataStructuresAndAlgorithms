package study_lc.study4_c;

import java.util.HashSet;
import java.util.Set;

public class NumOfEqualCountSubstring_2067 {
    public static void main(String[] args) {
//        String s = "aaabcbbcc";
//        int count = 3;

//        String s = "abcd";
//        int count = 2;

//        String s = "a";
//        int count = 5;

        String s = "bcbbcccbaaaxxxyyy";
        int count = 4;

        int result = equalCountSubstrings(s, count);
        int a = 5;

    }

    public static int equalCountSubstrings(String s, int count) {
        int[] char_freq = new int[26];
        Set<Character> possibleChars = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char curr_char = s.charAt(i);
            int curr_index = curr_char - 'a';
            char_freq[curr_index]++;

            if(char_freq[curr_index] >= count)
                possibleChars.add(curr_char);
        }

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char_freq = new int[26];
            Set<Character> uniqueChars = new HashSet<>();
            Set<Character> currChars = new HashSet<>();
            int numOfValid = 0;

            for(int j = i; j < s.length(); j++){
                char curr_char = s.charAt(j);
                int curr_index = curr_char - 'a';
                if(!possibleChars.contains(curr_char)){
                    break;
                }
                uniqueChars.add(curr_char);

                char_freq[curr_index]++;

                if(char_freq[curr_index] > count){
                    break;
                }
                if(char_freq[curr_index] == count && !currChars.contains(curr_char)){
                    currChars.add(curr_char);
                    numOfValid++;
                    if(uniqueChars.size() == numOfValid){
                        result++;
                    }
                }


            }
        }
        return result;
    }
}