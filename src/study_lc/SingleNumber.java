package study_lc;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,4,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int result = 0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
}
