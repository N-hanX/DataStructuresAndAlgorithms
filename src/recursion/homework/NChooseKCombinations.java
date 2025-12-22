package recursion.homework;

import java.util.ArrayList;

public class NChooseKCombinations {
    public static void main(String[] args) {
        find_combinations(5,2);
    }

    static ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        findCombinations(0, nums, currList, result, k);
        return result;
    }

    static void findCombinations(int curr_ind, ArrayList<Integer> nums, ArrayList<Integer> currPermList, ArrayList<ArrayList<Integer>> result, int k){
        if (currPermList.size() == k){
            ArrayList<Integer> copyList = new ArrayList<>(currPermList);
            result.add(copyList);
            return;
        }
        if(curr_ind == nums.size())
            return;

        currPermList.add(nums.get(curr_ind));
        findCombinations(curr_ind + 1, nums, currPermList, result, k);
        currPermList.remove(currPermList.size() - 1);
        findCombinations(curr_ind + 1, nums, currPermList, result, k);
    }
}
