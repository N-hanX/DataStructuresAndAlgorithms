package recursion.homework;

import java.util.*;

public class GenerateAllCombsWthSumEqual2Target {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,4,4));
        int target = 8;
        ArrayList<ArrayList<Integer>> result = generate_all_combinations(arr, target);
        return;
    }

    static ArrayList<ArrayList<Integer>> generate_all_combinations(ArrayList<Integer> arr, Integer target) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> currArr = new ArrayList<>();
        searchCombs(arr, target, result, currArr, 0,0);
        return result;
    }

    static void searchCombs(ArrayList<Integer> arr, Integer target, ArrayList<ArrayList<Integer>> result,
                            ArrayList<Integer> currArr, int currTotal, int currInd){
        if(currTotal > target){
            return;
        }else if(currTotal == target){
            result.add(new ArrayList<>(currArr));
            return;
        }

        if (currInd == arr.size()){
            return;
        }

        // find the same numbs
        int end = currInd;

        while(end < arr.size() && arr.get(end).equals(arr.get(currInd))){
            end++;
        }
        if(end == currInd){
            end = end + 1;
        }

        int diff_of_curr_ind = end - currInd;

        int count = 1;
        while(diff_of_curr_ind >= count){
            currArr.add(arr.get(currInd));
            searchCombs(arr, target, result, currArr, currTotal + (count * arr.get(currInd)), end);
            count = count + 1;
        }

        diff_of_curr_ind = end - currInd;
        while(diff_of_curr_ind > 0) {
            currArr.remove(currArr.size() - 1);
            diff_of_curr_ind = diff_of_curr_ind - 1;
        }

        searchCombs(arr, target, result, currArr, currTotal, end);

    }
}
