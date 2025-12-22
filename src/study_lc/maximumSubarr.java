package study_lc;

public class maximumSubarr {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSubArr = nums[0];
        int currSubArr = nums[0];

        for(int i = 1; i < nums.length; i++){
            currSubArr = Math.max(currSubArr, nums[i] + currSubArr);
            maxSubArr = Math.max(currSubArr, maxSubArr);
            int a = 5;
        }

        return maxSubArr;
    }
}
