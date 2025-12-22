package study4_i;

import java.util.HashMap;
import java.util.Map;

public class NumOfDivisibleTripletSums {
    public static void main(String[] args) {
//        int[] nums = new int[]{3, 3, 4, 7, 8};
//        int d = 5;
//
//        int[] nums = new int[]{3, 3, 3, 3};
//        int d = 3;


        int[] nums = new int[]{3, 3, 3, 3};
        int d = 6;

        int result = findNumOfTriples(nums, d);
        int a = 4;
    }

    public static int findNumOfTriples(int[] nums, int d){
        // find i,j,k triplets
        Map<Integer, Integer> modNumsWithFreqs = new HashMap<>();
        modNumsWithFreqs.put(nums[0] % d, 1);
        int numOfTriplets = 0;

        for(int j = 1; j < nums.length; j++){
            for(int k = j + 1; k < nums.length; k++){
                int sumOfJAndK = (nums[j] + nums[k]) % d;
                int modOfThisSum = sumOfJAndK % d;
                int need = (d - modOfThisSum) % d;
                if(need < 0){
                    need += d;
                }

                if(modNumsWithFreqs.containsKey(need)){
                    System.out.println("j: " + j + " k: " + k + " need: " + need);
                    numOfTriplets += modNumsWithFreqs.get(need);
                }
            }

            // now add this j for further triplets
            if(modNumsWithFreqs.containsKey(nums[j] % d)){
                modNumsWithFreqs.put(nums[j] % d, modNumsWithFreqs.get(nums[j] % d) + 1);
            }else{
                modNumsWithFreqs.put(nums[j] % d, 1);
            }
        }
        return numOfTriplets;
    }
}
