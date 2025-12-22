package study_lc.slidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
//        [1,3,2,2,5,2,3,7]
        int[] nums = new int[]{1,3,2,2,5,2,3,7};

        int result = findLHS(nums);
        int a = 4;
    }

    public static int findLHS(int[] nums) {
        int max_result = 0;

        Map<Integer, Integer> numsWithCounts = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int curr_num = nums[i];
            if(numsWithCounts.containsKey(curr_num)){
                int the_count = numsWithCounts.get(curr_num);
                numsWithCounts.put(curr_num, the_count + 1);
            }else{
                numsWithCounts.put(curr_num, 1);
            }
        }

        Set<Integer> numSet = numsWithCounts.keySet();
        Iterator iterator = numSet.iterator();

        while(iterator.hasNext()){
            int curr_num = (int)iterator.next();

            if(numsWithCounts.containsKey(curr_num - 1)){
                int curr_count = numsWithCounts.get(curr_num - 1) + numsWithCounts.get(curr_num);

                if(max_result < curr_count){
                    max_result = curr_count;
                }
            }

            if(numsWithCounts.containsKey(curr_num + 1)){
                int curr_count = numsWithCounts.get(curr_num + 1) + numsWithCounts.get(curr_num);

                if(max_result < curr_count){
                    max_result = curr_count;
                }
            }


        }
        return max_result;
    }
}

