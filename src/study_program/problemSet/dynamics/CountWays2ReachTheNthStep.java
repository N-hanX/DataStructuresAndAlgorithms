package study_program.problemSet.dynamics;

import java.util.ArrayList;
import java.util.Arrays;

public class CountWays2ReachTheNthStep {
    public static void main(String[] args) {
//        ArrayList<Integer> steps = new ArrayList<>(Arrays.asList(1, 2));
//        int n = 7;

        ArrayList<Integer> steps = new ArrayList<>(Arrays.asList(2, 3));
        int n = 7;

        Long result = count_ways_to_climb(steps, n);
        int a = 5;
    }

//    1 1 1 1
//    1 2 1
//    2 2
//    2 1 1

//    func(n) = func(n - 2) + func( n - 1) + f(n - 3)


    static Long count_ways_to_climb(ArrayList<Integer> steps, Integer n) {
        long[][] step_dp = new long[steps.size() + 1][n + 1];

        // func(n) = func(n-
        for(int i = 0; i <= steps.size(); i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 && j == 0){
                    step_dp[i][j] = 1L;
                    continue;
                }
                if(i == 0){
                    step_dp[i][j] = 0L;
                    continue;
                }
                if(j == 0){
                    step_dp[i][j] = 1L;
                    continue;
                }
                long count = 0L;
                for(int m = 0; m < i; m++) {
                    if(j - steps.get(m) >= 0) {
                        count += step_dp[i][j - steps.get(m)];
                    }
                }
                step_dp[i][j] = count;
            }
        }

        return step_dp[steps.size()][n];
    }

}
