package study_program.problemSet.string;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        String s = "efabcdhefhabcdiefi";
//        String s = "abcabcab";
//        String s = "aaaa";
//        String s = "aa";
        String result = get_longest_repeated_substring(s);

        int a = 4;
    }

    static String get_longest_repeated_substring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char currChar = 'A';

        for(int i = 0; i < 97; i++){
            charMap.put(currChar, i);
            currChar++;
        }

        int theMaxLen = s.length() - 2;
        int stringLen = s.length();

        while(theMaxLen >= 0){
            for(int startInd = 0; startInd < stringLen - theMaxLen; startInd++){
                int endInd = startInd + theMaxLen;
                String currSubstring = s.substring(startInd, endInd + 1);
                int possibleSubstringHashVal = calculateHashValue(currSubstring, charMap);

//                System.out.println("PATTERN: " + theMaxLen);
//                System.out.println( currSubstring);

                int endOfString = stringLen - theMaxLen;
                for(int j = startInd + 1; j < endOfString; j++){
                    String currString = s.substring(j, j + theMaxLen + 1);
//                    System.out.println("POSSIBLE STRING: " + currString);

                    int currStringHashVal = calculateHashValue(currString, charMap);
                    if(currStringHashVal == possibleSubstringHashVal && currString.equals(currSubstring)){
                        return currSubstring;
                    }
                }
            }
            theMaxLen--;
        }

        return null;
    }

    static int calculateHashValue_optimized(String text, Map<Character, Integer> charMap){
        int primeVal = 97;
        int baseVal = charMap.size();
        int result = 0;
        int textLen = text.length();

        for(int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            int currCharVal = charMap.get(currChar);

            int currHash = (int)(Math.pow(currCharVal, baseVal - textLen - 1)) % primeVal;
            result = result + currHash;
        }
        return result;
    }

    static int calculateHashValue(String text, Map<Character, Integer> charMap){
        int primeVal = 97;
        int baseVal = charMap.size();
        int result = 0;
        int textLen = text.length();

        for(int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            int currCharVal = charMap.get(currChar);

            int currHash = (int)(Math.pow(currCharVal, baseVal - textLen - 1)) % primeVal;
            result = result + currHash;
        }
        return result;
    }
}
