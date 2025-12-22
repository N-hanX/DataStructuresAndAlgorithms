package study4_a;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];

        // initial row for impossible movement
        for (int col = 1; col <= nums.length; col++) {
            dp[col] = -1; // 0. satır = başlangıç, diğerleri -1
        }

        dp[1] = 0; // starting point

        // dp index is one step away from the original index
        for (int i = 0; i < nums.length; i++) {
            int min_jump_to_curr_position = dp[i + 1];// the info is just one row above

            int curr_possible_jump_count = nums[i];
            int max_jump = Math.min(i + curr_possible_jump_count, nums.length - 1); // ?? neden boyle

            int curr_jump_ind = i;
            while (curr_jump_ind <= max_jump) {
                if (dp[curr_jump_ind + 1] == -1) {
                    dp[curr_jump_ind + 1] = min_jump_to_curr_position + 1;
                } else {
                    dp[curr_jump_ind + 1] = Math.min(dp[curr_jump_ind + 1], min_jump_to_curr_position + 1);
                }
                curr_jump_ind++;
            }

            // kopyala geri kalan sütunları
            for (int j = max_jump + 2; j <= nums.length; j++) { // max_jump+1 zaten işlenmişti
                dp[j] = dp[j];
            }
        }

        // son satırdaki son sütun minimum jump
        return dp[nums.length];
    }
}
