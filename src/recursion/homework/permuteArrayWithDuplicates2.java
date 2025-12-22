package recursion.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permuteArrayWithDuplicates2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        get_permutations(list);
    }

    static List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> allResults = new ArrayList<>();
        permutationHelper(arr, 0, allResults );
        return null;
    }

    static void permutationHelper(List<Integer> actualList, int startInd,
                                  List<List<Integer>> allResults){

        if(startInd == actualList.size()){
            List<Integer> copyList = new ArrayList<>(actualList);
            allResults.add(copyList);
        }

        HashSet<Integer> usedSet = new HashSet<>();

        for(int j = startInd; j < actualList.size(); j++){
            int currentElement = actualList.get(j);
            if(!usedSet.contains(currentElement)){
                usedSet.add(currentElement);
                swap(actualList, startInd, j);
                permutationHelper(actualList, startInd + 1, allResults);
                swap(actualList, startInd, j);
            }
        }
    }

    static void swap(List<Integer> currentArr, int i, int j){
        int temp = currentArr.get(i);
        currentArr.set(i, currentArr.get(j));
        currentArr.set(j, temp);
    }
}
