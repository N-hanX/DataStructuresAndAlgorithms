package recursion.problemSet;

import java.util.ArrayList;

public class GenerateAllSubsets {
//    Generate All Subsets Of A Set
//    Generate ALL possible subsets of a given set. The set is given in the form of a string s containing distinct lowercase characters 'a' - 'z'.
//    Example
//    Input: "xy"
//    Output: ["", "x", "y", "xy"]

    public static void main(String[] args) {
        String str = "xy";
        char[] chars = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            chars[i] = str.charAt(i);
        }
        ArrayList<String> strs = new ArrayList<>();
        subsetHelper(0, chars, strs);
    }

    public static String subsetHelper(int startInd, char[] chars, ArrayList<String> strs){
        if(startInd == chars.length){
            strs.add("");
            return "";
        }

        for(int i = startInd; startInd < chars.length; i++){
            // exclude
            String s =  subsetHelper(startInd + 1, chars, strs);
            strs.add(s);

            //include
            String s1 = chars[i] + subsetHelper(startInd, chars,strs);
            strs.add(s1);
        }
        return null;
    }
}
