package recursion.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromicDecompositionOfString {

    public static void main(String[] args) {
//        String str = "abcba";
//        String str = "abracadabra";
        String str = "abaab";
        generate_palindromic_decompositions(str);
    }

    static String[] generate_palindromic_decompositions(String s) {
        List<String> allResults = new ArrayList<>();
        int currInd = 0;
        Set<String> palindromicSet = new HashSet<>();

        stringDecompositionHelper(allResults, s, currInd, palindromicSet);
        currInd = 1;
        stringDecompositionHelper2(allResults, s, currInd, palindromicSet);


        String[] strList = new String[allResults.size()];
        for(int i = 0; i < strList.length; i++){
            strList[i] = allResults.get(i);
        }

        return strList;
    }

    public static void stringDecompositionHelper(List<String> allResults, String str,
                                          int currInd, Set<String> palindromicSet){

        if(currInd == str.length()){
            return;
        }

        for(int rangeInd = 0; rangeInd <= str.length() / 2; rangeInd++){
            if(isPalindrome(str, currInd, rangeInd )){
                String currPalindrome = palindromicStringBuilder(str, currInd, rangeInd);
                if(!palindromicSet.contains(currPalindrome)){
                    allResults.add(currPalindrome);
                    palindromicSet.add(currPalindrome);
                }
                stringDecompositionHelper(allResults, str, currInd + 1, palindromicSet);
            }else{
                return;
            }
        }
    }

    public static void stringDecompositionHelper2(List<String> allResults, String str,
                                                 int currInd, Set<String> palindromicSet){

        if(currInd == str.length()){
            return;
        }

        for(int rangeInd = 0; rangeInd <= str.length() / 2; rangeInd++){
            if(str.charAt(currInd) == str.charAt(currInd - 1)){
                if(isPalindrome2(str, currInd, rangeInd )){
                    String currPalindrome = palindromicStringBuilder2(str, currInd, rangeInd);
                    if(!palindromicSet.contains(currPalindrome)){
                        allResults.add(currPalindrome);
                        palindromicSet.add(currPalindrome);
                    }
                    stringDecompositionHelper2(allResults, str, currInd + 1, palindromicSet);
                }else{
                    return;
                }
            }else{
                stringDecompositionHelper2(allResults, str, currInd + 1, palindromicSet);
            }
        }

    }


    public static String palindromicStringBuilder(String string, int currInd, int rangeInd){
        int startIndOfPalindrome = currInd - rangeInd;
        int endIndOfPalindrome = currInd + rangeInd;

        String currPalindrome = "";

        for(int i = 0; i < startIndOfPalindrome; i++){
            if(i != string.length() - 1){
                currPalindrome = currPalindrome + string.charAt(i) + "|";
            }else{
                currPalindrome = currPalindrome + string.charAt(i);
            }

        }

        if(endIndOfPalindrome != string.length() - 1){
            currPalindrome = currPalindrome + string.substring(startIndOfPalindrome, endIndOfPalindrome + 1) + "|";
        }else{
            currPalindrome = currPalindrome + string.substring(startIndOfPalindrome, endIndOfPalindrome + 1);
        }


        for(int i = endIndOfPalindrome + 1; i < string.length(); i++){
            if(i != string.length() - 1){
                currPalindrome = currPalindrome + string.charAt(i) + "|";
            }else{
                currPalindrome = currPalindrome + string.charAt(i);
            }

        }
        return  currPalindrome;
    }


    public static String palindromicStringBuilder2(String string, int currInd, int rangeInd){
        int startIndOfPalindrome = currInd - rangeInd - 1;
        int endIndOfPalindrome = currInd + rangeInd;

        String currPalindrome = "";

        for(int i = 0; i < startIndOfPalindrome; i++){
            if(i != string.length() - 1){
                currPalindrome = currPalindrome + string.charAt(i) + "|";
            }else{
                currPalindrome = currPalindrome + string.charAt(i);
            }

        }

        if(endIndOfPalindrome != string.length() - 1){
            currPalindrome = currPalindrome + string.substring(startIndOfPalindrome, endIndOfPalindrome + 1) + "|";
        }else{
            currPalindrome = currPalindrome + string.substring(startIndOfPalindrome, endIndOfPalindrome + 1);
        }


        for(int i = endIndOfPalindrome + 1; i < string.length(); i++){
            if(i != string.length() - 1){
                currPalindrome = currPalindrome + string.charAt(i) + "|";
            }else{
                currPalindrome = currPalindrome + string.charAt(i);
            }

        }
        return  currPalindrome;
    }


    public static boolean isPalindrome(String currPalindrome, int currInd, int rangeInd){
        if(currInd + rangeInd < currPalindrome.length() && currInd - rangeInd >= 0){
            if(currPalindrome.charAt(currInd + rangeInd) == currPalindrome.charAt(currInd - rangeInd)){
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome2(String currPalindrome, int currInd, int rangeInd){
        if(currInd + rangeInd < currPalindrome.length() && currInd - rangeInd - 1 >= 0){
            if(currPalindrome.charAt(currInd + rangeInd) == currPalindrome.charAt(currInd - rangeInd - 1)){
                return true;
            }
        }
        return false;
    }

}
