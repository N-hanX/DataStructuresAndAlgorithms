package study_program.problemSet.adhoc;

import java.util.*;

public class LongestSubstringWithExactlyTwoDistinctCharacters {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaa00000000ba";
//        ecebaaaaca
//        String s = "ecebaaaaca";
        Integer result = get_longest_substring_length_with_exactly_two_distinct_chars(s);

        int a = 5;
    }

    static Integer get_longest_substring_length_with_exactly_two_distinct_chars(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);

        search_longest_substring(s, 0, result, 0);
        return result.get(0);
    }

    static int is_substring_done(String substring){
        Set<Integer> uniqueChars = new HashSet<>();

        for(int i = 0; i < substring.length(); i++){
            int curr_char = substring.charAt(i);
            if(Character.isAlphabetic(curr_char)){
                if(!uniqueChars.contains(curr_char)){
                    uniqueChars.add(curr_char);
                }
                if(uniqueChars.size() > 2){
                    return uniqueChars.size();
                }
            }
        }
        if(uniqueChars.size() == 2)
            return uniqueChars.size();
        return uniqueChars.size();
    }

    static void search_longest_substring(String s, int currEndInd,
                                         ArrayList<Integer> result, int startInd){
        if(currEndInd >= s.length() || startInd >= s.length()){
            return;
        }

        // control et
//        System.out.println("startInd: " + startInd + " endInd: " + currInd);
        String substring = s.substring(startInd, currEndInd + 1);
//        System.out.println(substring);
        if(substring != ""){
            if(is_substring_done(substring) == 2){
                if(!result.isEmpty() && result.get(0) < substring.length()){
//                    System.out.println("the current longest: " + substring);
                    result.set(0, substring.length());
                }
            }else if(is_substring_done(substring) > 2){
                return;
            }
        }

        if(currEndInd + 1 < s.length() && Character.isAlphabetic(s.charAt(currEndInd + 1))) {
            search_longest_substring(s, currEndInd + 1, result, startInd);
        }else{
            search_longest_substring(s, currEndInd + 2, result, startInd);
        }

        // ecebaaaaaca
        //eceb -> ece
        //eceb -> ceb

        int next_possible_index = currEndInd + 1;
        while(next_possible_index < s.length()){
            if(startInd + 1 < s.length() && Character.isAlphabetic(s.charAt(startInd + 1))){
                search_longest_substring(s, next_possible_index, result, startInd + 1);
            }else{
                search_longest_substring(s, next_possible_index, result, startInd + 2);
            }
            next_possible_index++;
        }
    }
}


