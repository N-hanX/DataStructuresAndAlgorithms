package study_lc;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

        int[] result = productExceptSelf(nums);

        int a = 4;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];

        int counter = 1;
        prefixArr[0] = 1;

        while(counter < nums.length){
            prefixArr[counter] = prefixArr[counter - 1] * nums[counter - 1];
            counter++;
        }

        counter = nums.length - 2;
        suffixArr[nums.length - 1] = 1;

        while(counter >= 0){
            suffixArr[counter] = suffixArr[counter + 1] * nums[counter + 1];
            counter--;
        }

        int[] products = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            products[i] = suffixArr[i] * prefixArr[i];
        }

        return products;
    }
}
