package study_lc.study4_c;

public class TwoSumII_InputArrIsSorted_167 {
    public static void main(String[] args) {
//        int[] numbers = new int[]{2,7,11,15};
//        int target = 9;

        int[] numbers = new int[]{2,3,4};
        int target = 6;

        int[] result = twoSum(numbers, target);

        int a =4;

    }
    public static int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = numbers.length - 1;
        int[] result = new int[2];

        while(ptr1 < ptr2){
            if(numbers[ptr1] + numbers[ptr2] > target){
                ptr2--;
            }else if(numbers[ptr1] + numbers[ptr2] < target){
                ptr1++;
            }else{
                result = new int[]{ptr1 + 1, ptr2 + 1};
                return result;
            }
        }
        return result;
    }
}
