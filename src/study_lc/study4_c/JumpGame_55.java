package study_lc.study4_c;

public class JumpGame_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        boolean result = canJump(nums);

        int a = 4;
    }

    public static boolean canJump(int[] nums) {
        int size = nums.length;
        boolean[][] dp = new boolean[size][size];

        for(int row = 0; row < size; row++){
            for(int col = row; col < size; col++){
                // System.out.println("row: " + row);
                // System.out.println("col: " + col);
                if(row == 0){
                    if(col <= nums[0]){
                        dp[row][col] = true;
                    }else{
                        dp[row][col] = false;
                    }
                }else{
                    if(row == col){
                        dp[row][col] = dp[row - 1][col];
                        // System.out.println("it could be reached" + dp[row-1][col]);
                    }else{
                        int furthest_next_position = row + nums[row];
                        // System.out.println("next position sorusu" + col);

                        if(col <= furthest_next_position &&  dp[row][row] || dp[row - 1][col]){
                            // System.out.println("next position" + col);
                            dp[row][col] =  true;
                        }
                    }
                }
            }
            if(dp[row][size - 1] == true){
                return true;
            }
        }

        return dp[size - 1][size - 1];
    }
}
