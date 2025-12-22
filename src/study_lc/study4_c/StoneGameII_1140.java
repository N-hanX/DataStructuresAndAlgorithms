package study_lc.study4_c;

import java.util.Arrays;

public class StoneGameII_1140 {
    public static void main(String[] args) {
//        int[] piles = new int[]{2, 7, 9, 4, 4};
        int[] piles = new int[]{1, 2, 3, 4, 5, 100};
        int result = stoneGameII(piles);
        int a =4;
    }

    // not my solution
    static int[][][] dp;

    public static int stoneGameII(int[] piles){
        int n = piles.length;
        dp = new int[n][n + 1][2];

        for(int[][] row: dp){
            for(int[] innerRow: row){
                Arrays.fill(innerRow, -1);
            }
        }
        return helper(piles, 0, 1, 1);
    }

    private static int helper(int[] piles, int index, int M, int turn){
        if(index == piles.length){
            return 0;
        }

        if(dp[index][M][turn] != -1)
            return dp[index][M][turn];

        int res;
        if(turn == 1){
            res = 0;
        }else{
            res = Integer.MAX_VALUE;
        }

        int stones = 0;
        for(int X = 0; X < 2 * M; X++){
            if(index + X >= piles.length){
                break;
            }
            stones += piles[index + X];

            if(turn == 1){
                res = Math.max(res, stones + helper(piles, index + X + 1, Math.max(M, X + 1), 0));
            }else{
                res = Math.min(res, helper(piles, index + X + 1, Math.max(M, X + 1), 1));
            }
        }

        dp[index][M][turn] = res;
        return res;
    }
}
