package recursion.homework;

import java.util.ArrayList;
import java.util.List;

public class homework1_1 {

    public static void main(String[] args) {
        letter_case_permutations("a1z");
    }

    public static List<String> letter_case_permutations(String str) {


        List<String> allResults = new ArrayList<>();


        helpCasePermutation(str, 0, "", allResults);
        return allResults;

    }

    public static void helpCasePermutation(String str, int startInd, String currentBuiltStr, List<String> allResults ){
        if(startInd == str.length() ){
            allResults.add(currentBuiltStr);
            return;
        }

        if(!Character.isDigit(str.charAt(startInd))){
            String newBuiltStr1 = currentBuiltStr + Character.toLowerCase(str.charAt(startInd));

            helpCasePermutation(str, startInd + 1, newBuiltStr1, allResults);


            String newBuiltStr2 = currentBuiltStr + Character.toUpperCase(str.charAt(startInd));
            helpCasePermutation(str, startInd + 1, newBuiltStr2, allResults);

        }else{

            currentBuiltStr = currentBuiltStr + str.charAt(startInd);
            startInd++;
            helpCasePermutation(str, startInd, currentBuiltStr, allResults);
        }
    }
}
