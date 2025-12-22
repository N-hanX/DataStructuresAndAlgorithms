package recursion.homework;

import java.util.*;

public class generateCombsWithDuplicatesToSumTarget {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = 3;

        generate_all_combinations(list, sum);
    }


    public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        Collections.sort(arr);

        List<Integer> currList = new ArrayList<>();
        List<List<Integer>> allResults = new ArrayList<>();
        Set<String> combinationSet = new HashSet<>();
        int currSum = 0;
        int currInd = 0;
        combsToSumTargetHelper(arr, currInd, currList, allResults, target, combinationSet, currSum);
        return allResults;
    }

    public static void combsToSumTargetHelper(List<Integer> arr, int currInd, List<Integer> currList,
                                              List<List<Integer>> allResults, int target,
                                              Set<String> combinationSet, int currSum){
        if(currInd == arr.size() && currSum != target){
            return;
        }

        if(currSum > target){
            return;
        }

        if(currSum == target){
            String str = createStrOfCombination(currList);

            if(!combinationSet.contains(str)) {
                List<Integer> copyList = new ArrayList<>(currList);
                allResults.add(copyList);

                combinationSet.add(str);
            }

            return;
        }


        //include
        currList.add(arr.get(currInd));
        currSum = currSum + arr.get(currInd);
        combsToSumTargetHelper(arr, currInd + 1, currList, allResults, target, combinationSet, currSum);
        currList.remove(currList.size() - 1);
        currSum = currSum - arr.get(currInd);

        //exclude
        combsToSumTargetHelper(arr, currInd + 1, currList, allResults, target, combinationSet, currSum);
    }

    public static String createStrOfCombination(List<Integer> list){
        String str = "";
        for(int i = 0; i < list.size(); i++){
            str = str + list.get(i).toString();
        }
        return str;
    }

}
