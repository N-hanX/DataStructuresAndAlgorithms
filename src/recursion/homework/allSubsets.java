package recursion.homework;

import java.util.ArrayList;
import java.util.List;

public class allSubsets {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        get_subsets(list);
    }

    static List<List<Integer>> get_subsets(List<Integer> arr) {
        List<List<Integer>> allResults = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        subsetHelper(arr, 0, allResults, currSubset );
        return null;
    }

    static void subsetHelper(List<Integer> actualList, int startInd,
                                  List<List<Integer>> allResults, List<Integer> currSubset){

        if(startInd == actualList.size()){
            List<Integer> copyCurrSubset = new ArrayList<>(currSubset);
            allResults.add(copyCurrSubset);
            return;
        }
//        //include
//        currSubset.add(actualList.get(startInd));
//        subsetHelper(actualList, startInd + 1, allResults, currSubset);
//        // exclude
//        currSubset.remove(currSubset.size() - 1);
//        subsetHelper(actualList, startInd + 1, allResults, currSubset);

        // exclude
        subsetHelper(actualList, startInd + 1, allResults, currSubset);

        //include
        currSubset.add(actualList.get(startInd));
        subsetHelper(actualList, startInd + 1, allResults, currSubset);
        currSubset.remove(currSubset.size() - 1);
    }

}
