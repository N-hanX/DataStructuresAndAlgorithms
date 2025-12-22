package recursion.problemSet;

import java.util.ArrayList;
import java.util.List;

public class brackets {
    public static void main(String[] args) {
        int n = 3;
        find_all_well_formed_brackets(n);
    }

    static String[] find_all_well_formed_brackets(int n) {
        int leftInd = 0;
        int rightInd = 0;
        List<String> allResults = new ArrayList<>();
        String currStr = "";
        helper(n, leftInd, rightInd, allResults, currStr);
        return null;
    }

    static void helper(int n, int leftParantInd, int rightParantInd, List<String> allResults, String str){
        if(rightParantInd == n){
            allResults.add(str);
            return;
        }
        if(leftParantInd == n){
            return;
        }

        str = str + "(" ;
        helper(n, leftParantInd + 1, rightParantInd, allResults, str);
        str = str + ")";
        str.substring(0, str.length());
        helper(n, leftParantInd + 1, rightParantInd + 1, allResults, str);
    }


}
