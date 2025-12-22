package study_lc.strings;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> words = new ArrayList<>(Arrays.asList("leet","code"));

//        String s = "applepenapple";
//        List<String> words = new ArrayList<>(Arrays.asList("apple","pen"));

//        String s = "catsandog";
//        List<String> words = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
//
//        String s = "ab";
//        List<String> words = new ArrayList<>(Arrays.asList("a","b"));

//        String s = "abcd";
//        List<String> words = new ArrayList<>(Arrays.asList("a","abc","b","cd"));

//        String s = "aaaaaaa";
//        List<String> words = new ArrayList<>(Arrays.asList("aaaa","aa"));
//
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> words = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

//        String s = "aaaaaaa";
//        List<String> words = new ArrayList<>(Arrays.asList("aaaa","aaa"));

        String s = "catsandogcat";
        List<String> words = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat","an"));


        boolean result = wordBreak(s, words);


        int a = 4;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        // Create a set of words from the list so that the lookup cost in the set becomes O(1)
        Set<String> wordSet = new HashSet<>(wordDict);

        // Initialize the lookup table
        boolean[] dp = new boolean[n + 1];

        // Set the first element to true as it represents the empty string
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Checking if the substring from j to i is present in the wordSet and dp[j] is true
                String subString = s.substring(j, i);
                if (dp[j] && wordSet.contains(subString)){
                    dp[i] = true;
                    // If a substring is found, no need to check further smaller substrings
                    break;
                }
            }
        }

        // Return the last element of dp array
        return dp[n];
    }
}
