package study4_a;

public class HouseRobber4_2560 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        int k = 2;

        int result = minCapability(nums, k);
        int a = 4;
    }

    public static int minCapability(int[] nums, int k) {
        int low_num = 1;
        int high_num = Integer.MAX_VALUE;
        int result = 0;

        while(low_num <= high_num){
            int med_num = low_num + (high_num - low_num) / 2;

            if(canRob(nums, med_num, k)){ // find a better value which means the lower one.
                result = med_num;
                high_num = med_num - 1;
            }else{
                low_num = med_num + 1;
            }
        }
        return result;
    }

    public static boolean canRob(int[] nums, int med_num, int k){
        int totalPossibleRob = 0;

        for(int i = 0; i < nums.length; ){
            if(nums[i] <= med_num){
                totalPossibleRob++;
                i += 2;
            }else{
                i++;
            }
        }
        return totalPossibleRob >= k;
    }
}
