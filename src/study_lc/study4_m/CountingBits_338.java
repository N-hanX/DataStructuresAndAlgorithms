package study_lc.study4_m;

public class CountingBits_338 {

    //not my solutions. it is for study

    public static void main(String[] args) {
        int n = 15; // Output: [0,1,1,2,1,2]
//        0 --> 0
//        1 --> 1
//        2 --> 10
//        3 --> 11
//        4 --> 100
//        5 --> 101
        int[] result = countBits(n);
        int a = 4;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
            System.out.println("*****");
            System.out.println("ans[i >> 1] + (i & 1)");
            System.out.println("ans[" + i + " >> 1] + (" + i + " & 1)");
            System.out.println("ans[" + (i >> 1) + "] + (" + (i & 1) + ")");
            System.out.println(ans[i >> 1] + "+" + (i & 1));

        }

        return ans;
    }
}
