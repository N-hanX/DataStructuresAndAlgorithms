package study_lc.study4_c;

import java.util.HashSet;
import java.util.Set;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);

        int a = 4;

    }

    public static void rotate(int[] nums, int k) {
        visited = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!visited.contains(i)){
                recursivelyTraverse(nums,nums[i], (i + k) % nums.length, k);
            }
        }
    }

    static Set<Integer> visited;
    public static void recursivelyTraverse(int[] nums, int currVal, int newPlaceInd, int k){
        if(visited.contains(newPlaceInd)){
            return;
        }
        visited.add(newPlaceInd);
        int temp = nums[newPlaceInd];
        nums[newPlaceInd] = currVal;
        int next_ind = (newPlaceInd + k) % nums.length;
        recursivelyTraverse(nums, temp, next_ind, k);
    }
}
