package recursion.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class allSubsetsWithDuplicates {

    public static void main(String[] args) {
        String str = "aab";

        List<Character> list1 = new ArrayList<>();

        for(int i = 0 ; i < str.length(); i ++){
            list1.add(str.charAt(i));
        }

        get_subsets(list1);

    }

    static List<String> get_subsets(List<Character> arr) {
        List<String> allResults = new ArrayList<>();
        String currStr = "";
        Set<String> allUniqueStrs = new HashSet<>();
        subsetHelper(arr, 0, allResults, currStr, allUniqueStrs );
        return allResults;
    }

    static void subsetHelper(List<Character> actualList, int startInd,
                                  List<String> allResults, String currStr,
                             Set<String> allUniqueStrs ){

        if(startInd == actualList.size()){
            if(!allUniqueStrs.contains(currStr)){
                allUniqueStrs.add(currStr);
                allResults.add(currStr);
            }
            return;
        }

        //include
        currStr = currStr + actualList.get(startInd);
        subsetHelper(actualList, startInd + 1, allResults, currStr, allUniqueStrs);
        currStr = currStr.substring(0, currStr.length() - 1);

        // exclude
        subsetHelper(actualList, startInd + 1, allResults, currStr, allUniqueStrs);

    }

}
