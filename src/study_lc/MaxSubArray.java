package study_lc;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        int max_val = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int max_curr_val = arr[i];

            for(int j = i + 1; j < arr.length; j++){
                max_curr_val = max_curr_val + arr[j];

                if(max_val < max_curr_val){
                    max_val = max_curr_val;
                }
            }
        }
        int a = 5;





    }
}
