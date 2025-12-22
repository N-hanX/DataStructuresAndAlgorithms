package recursion.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permuteArrayWithDuplicates {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        get_permutations(list);
    }

    static List<List<Integer>> get_permutations(List<Integer> arr) {
        List<Integer> copyList = new ArrayList<>();
        HashSet<Integer> usedSet = new HashSet<>();
        List<Integer> currentCreatedList = new ArrayList<>();
        List<List<Integer>> allResults = new ArrayList<>();
        permutationHelper(arr, 0, copyList, usedSet, currentCreatedList, allResults );
        return null;
    }

    static void permutationHelper(List<Integer> actualList, int startInd, List<Integer> remainingList,
                                  HashSet<Integer> usedSet, List<Integer> currentCreatedList, List<List<Integer>> allResults){
        if(remainingList.size() == 0){
            allResults.add(currentCreatedList);
            return;
        }

        usedSet.add(actualList.get(startInd));
        remainingList.remove(actualList.get(startInd));
        permutationHelper(actualList, startInd++, remainingList, usedSet, currentCreatedList, allResults);
        remainingList.remove(actualList.get(startInd));
    }





}
