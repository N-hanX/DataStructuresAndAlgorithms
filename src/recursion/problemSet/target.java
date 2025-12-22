package recursion.problemSet;

import java.util.ArrayList;
import java.util.List;

public class target {
    public static void main(String[] args) {
        long[] arr = new long[3];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 8;
        int sum = 6;
        check_if_sum_possible(arr, sum);
    }

    static boolean check_if_sum_possible(long[] arr, long k) {
        long sum = 0L;
        long target = k;
        int currInd = 0;
        boolean found = false;

        List<Long> allResults = new ArrayList<>();
        helper(arr, target, sum, currInd, found, allResults);

        if(allResults.size() > 0){
            return true;
        }else{
            return false;
        }


    }

    static void helper(long[] arr, long target ,long sum, int currInd, boolean found, List<Long> allResults){
        if(sum == target){
            allResults.add(sum);
            return;
        }

        if(currInd ==  arr.length){
            return;
        }



        for(int i = currInd; i < arr.length; i++){
            sum = sum + arr[i];
            helper(arr, target, sum, currInd + 1, found, allResults);
            sum = sum - arr[i];
            helper(arr,target, sum, currInd + 1, found,  allResults);
        }


    }
}
