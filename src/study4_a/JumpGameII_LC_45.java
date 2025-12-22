package study4_a;

public class JumpGameII_LC_45 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{2, 3, 0, 1, 4};
        int result = dp_approach_jump(nums);
        int result2 = greedy_jump_solutionAIExercise(nums);
        int a = 5;
    }

    public static int dp_approach_jump(int[] nums) {
        int[] dp = new int[nums.length + 1];

        // initial row for impossible movement
        for (int col = 1; col <= nums.length; col++) {
            dp[col] = -1;
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


            for (int j = max_jump + 2; j <= nums.length; j++) {
                dp[j] = dp[j];
            }
        }


        return dp[nums.length];
    }


    public static int greedy_jump_solutionAIExercise(int[] nums){
        int jumps = 0;          // Kaç kere zıpladığımızı sayar
        int currentEnd = 0;     // Şu anki zıplayışla ulaşabileceğimiz en uzak nokta
        int farthest = 0;       // Şu ana kadar görebildiğimiz en uzak nokta

        // Son indexten önceye kadar geziyoruz
        for (int i = 0; i < nums.length - 1; i++) {

            // Bu adımda ulaşabileceğimiz en uzak noktayı güncelle
            farthest = Math.max(farthest, i + nums[i]);

            // Eğer bu adım, şu anki zıplama menzilimizin sonuna geldiyse:
            if (i == currentEnd) {
                jumps++;                // Bir zıplama daha gerekir
                currentEnd = farthest;  // Yeni zıplama menzilini belirle
            }
        }

        return jumps;
    }
}
