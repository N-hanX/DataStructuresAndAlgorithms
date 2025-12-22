package study_lc.study4_c;

public class MoveZeros_283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        int a = 4;
    }

    public static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroIndex] = nums[i];
                if(i != lastNonZeroIndex)
                    nums[i] = 0;
                lastNonZeroIndex++;
            }
        }
    }
}
