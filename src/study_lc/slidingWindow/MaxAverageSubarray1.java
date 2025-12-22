package study_lc.slidingWindow;

public class MaxAverageSubarray1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;

        double result = findMaxAverage(nums, k);
        int a = 4;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int startInd = 0;
        int endInd = k - 1;
        int arr_len = nums.length;

        double max_total = 0;
        double curr_total = 0;

        int ind_iterator = startInd;
        while(ind_iterator <= endInd){
            curr_total += nums[ind_iterator];
            ind_iterator++;
        }
        max_total = curr_total;

        endInd++;
        while(startInd < arr_len && endInd < arr_len){
            double currStart = nums[startInd];
            double currEnd = nums[endInd];

            curr_total = curr_total - currStart + currEnd;
            if(max_total < curr_total){
                max_total = curr_total;
            }
            endInd++;
            startInd++;
        }

        return max_total / k;
    }
}
