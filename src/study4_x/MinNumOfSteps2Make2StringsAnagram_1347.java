package study4_x;

public class MinNumOfSteps2Make2StringsAnagram_1347 {
    public static void main(String[] args) {
        //string s = "bab", t = "aba"
//        String s = "bab";
//        String t = "aba";

        // s = "leetcode", t = "practice"
        String s = "leetcode";
        String t = "practice";

        int result = minSteps(s, t);
        int a = 4;
    }

    public static int minSteps(String s, String t) {
        char[] freq_s = new char[26];
        char[] freq_t = new char[26];

        for(int i = 0; i < s.length(); i++){
            freq_s[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            freq_t[t.charAt(i) - 'a']++;
        }

        int result = 0;
        for(int i = 0; i < 26; i++){
            if(freq_t[i] > freq_s[i]){
                result++;
            }
        }
        return result;
    }
}
