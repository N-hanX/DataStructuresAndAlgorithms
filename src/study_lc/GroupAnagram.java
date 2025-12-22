package study_lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);

        int a = 4;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String currString = strs[i];

            int[] charOccurance = new int[26];
            for(int ind = 0; ind < currString.length(); ind++){
                char currChar = currString.charAt(ind);

                charOccurance[currChar - 'a']++;
            }

            StringBuilder charOccuranceStringBuilder = new StringBuilder();
            for(int ind = 0; ind < 26; ind++){
                charOccuranceStringBuilder.append(charOccurance[ind]).append("_");
            }

            String charOccuranceString = charOccuranceStringBuilder.toString();

            if(anagramMap.containsKey(charOccuranceString)){
                List<String> currGroup = anagramMap.get(charOccuranceString);
                currGroup.add(currString);
            }else{
                List<String> currGroup = new ArrayList<>();
                currGroup.add(currString);
                anagramMap.put(charOccuranceString, currGroup);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(String charOccuranceString : anagramMap.keySet()){
            List<String> currGroup = new ArrayList<>();
            result.add(anagramMap.get(charOccuranceString));
        }

        return result;
    }
}
