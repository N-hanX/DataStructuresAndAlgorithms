package study_lc.study4_i;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrOfDistinctSubarrsWithLengthK {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,5,4,2,9,9,9};
//        int k = 3;

//        int[] nums = new int[]{4, 4, 4};
//        int k = 3;

        // 1,1,1,7,8,9

//        int[] nums = new int[]{1,1,1,7,8,9};
//        int k = 3;

//        int[] nums = new int[]{1,1,1,1,1,1};
//        int k = 2;

//        int[] nums = new int[]{1,5,5,5};
//        int k = 2;


        //[1,2,1,1,3]

        int[] nums = new int[]{1,2,1,1,3};
        int k = 2;

        long result = maximumSubarraySum(nums, k);
        int x = 3;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int startInd = findTheStartInd(nums,k);
        if(startInd  == -1)
            return 0L;
        int endInd = startInd + k - 1;
        if(endInd >= nums.length)
            return 0L;

        long maxTotal = 0L;
        long currTotal = 0L;
        int currInd = startInd;
        Map<Integer, Integer> numIndexInfo = new HashMap<>();

        while(currInd <= endInd){
            numIndexInfo.put(nums[currInd], currInd);
            currTotal += nums[currInd];
            currInd++;
        }

        maxTotal = currTotal;

        while(currInd < nums.length){
            if(numIndexInfo.containsKey(nums[currInd])){
                currInd = numIndexInfo.get(nums[currInd]) + 1;
                // re calculate totals
                numIndexInfo = new HashMap<>();
                endInd = currInd + k - 1;
                if(endInd >= nums.length || currInd >= nums.length){
                    break;
                }
                startInd = currInd;
                currTotal = calculateTotalInRange(nums, startInd, endInd, numIndexInfo);

                if(currTotal == -1)
                    currInd++;

                if(currTotal > maxTotal){
                    maxTotal = currTotal;
                }
                startInd++;
                endInd++;
            }else{
                currTotal = currTotal - nums[startInd] + nums[currInd];

                numIndexInfo.put(nums[currInd], currInd);
                numIndexInfo.remove(nums[startInd]);

                if(currTotal > maxTotal){
                    maxTotal = currTotal;
                }
                startInd++;
                endInd++;
                currInd++;
            }
        }

        return maxTotal;
    }

    public static long calculateTotalInRange(int[] nums, int start_ind, int end_ind, Map<Integer, Integer> numIndexInfo){
        long total = 0L;

        while(start_ind <= end_ind){
            if(numIndexInfo.containsKey(nums[start_ind])){
                return -1;
            }
            total += nums[start_ind];
            numIndexInfo.put(nums[start_ind], start_ind);
            start_ind++;
        }
        return total;
    }

    public static int findTheStartInd(int[] nums, int k){
        Map<Integer, Integer> numIndexInfo = new HashMap<>();

        int startInd = 0;
        int endInd = k - 1;
        int currInd = 0;

        while(currInd < nums.length && currInd <= endInd){
            if(!numIndexInfo.containsKey(nums[currInd])){
                numIndexInfo.put(nums[currInd], currInd);
                currInd++;
                endInd = startInd + k - 1;
            }else{
                startInd = numIndexInfo.get(nums[currInd]) + 1;
                numIndexInfo = new HashMap<>();
                currInd = startInd;
                endInd = startInd + k - 1;
                if(endInd >= nums.length)
                    return -1;
            }
        }

        return startInd;
    }
}
