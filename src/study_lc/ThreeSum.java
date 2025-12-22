package study_lc;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,1,2,-1,-4};

        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = threeSum(nums);

        int a = 4;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numArr = new ArrayList<>();
        Set<List<Integer>> setResult = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            numArr.add(nums[i]);
        }

        Collections.sort(numArr);
        int target = 0;

        for(int i = 0; i < numArr.size(); i++){
            int num1 = numArr.get(i); // first constant

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int num2 = numArr.get(j);
                int num3 = numArr.get(k);

                int currTotal = num1 + num2 + num3;

                if(target > currTotal){
                    j++;
                }else if (target < currTotal){
                    k--;
                }else{
                    setResult.add(new ArrayList<>(Arrays.asList(num1, num2, num3)));
                    j++;
                    k--;
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(setResult);
        return list;
    }
}
