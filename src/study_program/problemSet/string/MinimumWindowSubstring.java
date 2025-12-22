package study_program.problemSet.string;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "AYZABOBECODXBANC";
        String t = "ABC";

        String result = minimum_window(s, t);

        int a = 4;
    }

    static String minimum_window(String s, String t) {
        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            freq1[c]++;
        }

        String result = "";
        int n = s.length();
        int l = 0;
        int len = n + 1;
        int m = t.length();

        int cnt = 0;

        for(int i = 0; i < n; i++){
            char temp = s.charAt(i);
            freq2[temp]++;

            if(freq1[temp] != 0 && freq2[temp] <= freq1[temp]){
                cnt++;
            }

            if(cnt == m){

                while(freq2[s.charAt(l)] > freq1[s.charAt(l)] || freq1[s.charAt(l)] == 0){
                    if(freq2[s.charAt(l)] > freq1[s.charAt(l)]){
                        freq2[s.charAt(l)]--;
                    }
                    l++;
                }

                if(len > i - l + 1){
                    len = i - l + 1;
                    result = s.substring(l, l + len);
                }
            }
        }

        return result;
    }
}
