package study_lc.study4_c;

import java.util.Arrays;

public class MinimumDels2MakeCharFreqUnique_1647 {
    public static void main(String[] args) {
//        String s = "ceabaacb";
//        String s = "aaabbbcc";
        String s = "aab";

        int result = minDeletions(s);
        int a =4;
    }

    public static int minDeletions(String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        Arrays.sort(counts);

        int actionCount = 0;
        int lowestAvailableCount = counts[25] - 1;
        for (int i = 24; i >= 0; i--) {
            if (lowestAvailableCount > 0) {
                if (counts[i] > lowestAvailableCount) {
                    actionCount += (counts[i] - lowestAvailableCount);
                    lowestAvailableCount--;
                } else if (counts[i] == lowestAvailableCount) {
                    lowestAvailableCount--;
                } else {
                    lowestAvailableCount = counts[i] - 1;
                }
            } else {
                actionCount += counts[i];
            }
        }

        return actionCount;
    }
}
