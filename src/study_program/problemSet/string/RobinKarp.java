package study_program.problemSet.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RobinKarp {
    public static void main(String[] args) {
//        String text = "this is a test text";
//        String pattern = "test";

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        ArrayList<Integer> patternIndices = searchPattern(pattern, text);

        int a = 4;
    }

    public static ArrayList<Integer> searchPattern(String pattern, String text){
        Map<Character, Integer> charMap = new HashMap<>();
        ArrayList<Integer> patternIndices = new ArrayList<>();

        char currChar = ' ';
        for(int i = 0; i < 97; i++){
            charMap.put(currChar, i);
            currChar++;
        }

        int textLength = text.length();
        int patternLength = pattern.length();
        int patternHashValue = calculateHashValue(pattern, charMap);

        for(int textInd = 0; textInd <= textLength - patternLength; textInd++){
            System.out.println("ind: " + textInd);
            String currTextPattern = text.substring(textInd, textInd + patternLength);

            int hashValueTextSubstring = calculateHashValue(currTextPattern, charMap);

            if(patternHashValue == hashValueTextSubstring && pattern.equals(currTextPattern)){
                patternIndices.add(textInd);
            }
        }
        return patternIndices;
    }

    public static int calculateHashValue(String text, Map<Character, Integer> charMap){
        int hashValue = 0;
        int baseValue = charMap.size();
        int primeValue = 29;

        for(int i = 0; i < text.length(); i++){
            char currChar = text.charAt(i);

            System.out.println(currChar);
            int charValue = charMap.get(currChar);

            hashValue = hashValue + (charValue * (int)Math.pow(baseValue, text.length() - i - 1) % primeValue);
        }
        return hashValue;
    }


}
