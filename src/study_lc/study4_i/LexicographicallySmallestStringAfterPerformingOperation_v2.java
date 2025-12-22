package study_lc.study4_i;

public class LexicographicallySmallestStringAfterPerformingOperation_v2 {
    public static void main(String[] args) {
        String s = "acbbc";
        String result = smallestString(s);

        int a = 4;
    }

    public static String smallestString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 'a') {
                while (i < n && arr[i] != 'a') {
                    arr[i++]--;
                }
                return new String(arr);
            }
        }

        arr[n - 1] = 'z';
        return new String(arr);
    }
}
