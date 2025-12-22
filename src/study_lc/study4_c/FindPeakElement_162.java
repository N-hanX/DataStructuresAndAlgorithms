package study_lc.study4_c;

public class FindPeakElement_162 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int result = findPeakElement(nums);

        int a = 4;
    }
    public static int findPeakElement(int[] nums) {
        int result_ind = binarySearch(0, nums.length - 1, nums);
        if(result_ind == -1)
            return 0;
        return result_ind;
    }

    public static int binarySearch(int start_ind, int end_ind, int[] nums){
        if(start_ind > end_ind || start_ind < 0 || end_ind > nums.length){
            return -1;
        }

        int middle_ind = (end_ind - start_ind) / 2 + start_ind;
        int left_ind  = middle_ind - 1;
        int right_ind = middle_ind + 1;

        // System.out.println(" left: " + left_ind + " - right_ind: " + right_ind + " middle:" + middle_ind);

        if(left_ind >= 0 && right_ind < nums.length &&
                nums[middle_ind] > nums[right_ind] && nums[middle_ind] > nums[left_ind]){
            // System.out.println("middle bulundu: " + middle_ind);
            return middle_ind;
        }else if(left_ind >= 0 && right_ind >= nums.length && nums[middle_ind] > nums[left_ind]){
            // System.out.println("just left: " + middle_ind);
            return middle_ind;
        }else if(left_ind < 0 && right_ind < nums.length && nums[middle_ind] > nums[right_ind]){
            // System.out.println("just right: " + middle_ind);
            return middle_ind;
        }

        int leftResult = binarySearch(start_ind, middle_ind - 1, nums);
        if(leftResult >= 0)
            return leftResult;
        int rightResult = binarySearch(middle_ind + 1, end_ind, nums);
        if(rightResult >= 0)
            return rightResult;

        return -1;
    }
}
