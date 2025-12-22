package study_program.problemSet.string;

import java.util.HashMap;

public class LongestSubstringWithExactlyTwoDistinctCharacters_v2 {
    public static void main(String[] args) {
        String s = "ecebaaaaca";

        int result = get_longest_substring_length_with_exactly_two_distinct_chars(s);

        int a = 4;
    }

    static Integer get_longest_substring_length_with_exactly_two_distinct_chars(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int max_len = 0;
        while (right < s.length()) {
            // We are maintaining character along with it's frequency
            if (countMap.containsKey(s.charAt(right))) {
                countMap.put(s.charAt(right), countMap.get(s.charAt(right)) + 1);
            }
            else{
                countMap.put(s.charAt(right), 1);
            }
            // If size of countMap is more than 2 means substring s[left, right]
            // have more than 2 distinct characters so, we remove characters from left
            // while countMap size is more than 2
            while (countMap.size() > 2) {
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                if (countMap.get(s.charAt(left)) == 0){
                    countMap.remove(s.charAt(left));
                }
                left++;
            }
            // If size of countMap is equal to 2 means substring s[left, right]
            // is composed of exactly 2 distinct characters hence we compare and store max_len
            if (countMap.size() == 2) {
                max_len = Math.max(max_len, right - left + 1);
            }
            right++;
        }
        return max_len;
    }
}
