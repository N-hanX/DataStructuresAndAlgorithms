package study4_a;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prefixSumTill_ith_index = new int[nums.length];
        prefixSumTill_ith_index[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefixSumTill_ith_index[i] = prefixSumTill_ith_index[i - 1] + nums[i];
        }

        Map<Integer, Integer> prefixMapWithCount = new HashMap<>();
        prefixMapWithCount.put(0, 1);

        for(int i = 0; i < prefixSumTill_ith_index.length; i++){
            int neededSubArrayDiff = prefixSumTill_ith_index[i] - k;
            // System.out.println("curr prefix: " + prefixSumTill_ith_index[i]);
            if(prefixMapWithCount.containsKey(neededSubArrayDiff)){
                // System.out.println("bulundu");
                count = count + prefixMapWithCount.get(neededSubArrayDiff);
            }
            int currentCount = prefixMapWithCount.getOrDefault(prefixSumTill_ith_index[i], 0);
            // System.out.println("curr count: " + currentCount);
            prefixMapWithCount.put(prefixSumTill_ith_index[i], currentCount + 1);
        }

        return count;
    }
}
