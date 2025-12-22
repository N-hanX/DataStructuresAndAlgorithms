package study_program.problemSet.string;

import java.util.*;

public class LongestSubstringWithExactlyTwoDistinctCharacters {
    public static void main(String[] args) {
        String s = "ecebaaaaca";

        int result = get_longest_substring_length_with_exactly_two_distinct_chars(s);

        int a = 4;
    }


    static Integer get_longest_substring_length_with_exactly_two_distinct_chars(String s) {
        int startPoint = 0;
        int endPoint = 0;
        Map<Character, ArrayList<Integer>> characterIndices = new HashMap<>();
        Set<Character> currChars = new HashSet<>();
        int result = 0;

        if(s == null)
            return 0;

        char startChar = s.charAt(startPoint);

        while(startPoint != s.length() && endPoint != s.length()){
            char endChar = s.charAt(endPoint);

            if(currChars.size() < 2) {
                currChars.add(endChar);
                if(characterIndices.containsKey(endChar)){
                    ArrayList<Integer> indexList = characterIndices.get(endChar);
                    indexList.add(endPoint);
                }else {
                    characterIndices.putIfAbsent(endChar, new ArrayList<>(Arrays.asList(endPoint)));
                }
                if(result < (endPoint - startPoint + 1) && currChars.size() == 2){
                    result = endPoint - startPoint + 1;
                }
            }else if(currChars.size() == 2){
                // if endchar zaten olan bir karakter ise
                if(currChars.contains(endChar)){
                    ArrayList<Integer> indices = characterIndices.get(endChar);
                    indices.add(endPoint);

                    if(result < (endPoint - startPoint + 1) && currChars.size() == 2){
                        result = endPoint - startPoint + 1;
                    }
                }else{// if endchar zaten olan biri karakter degil ise onu onceleklendirip digerinden kurtulacagiz.
                    // startPointi duzenlicez
                    char prevChar = s.charAt(endPoint - 1);
                    char otherChar = '0';
                    for(char currChar : currChars){
                        if(prevChar != currChar)
                            otherChar = currChar;
                    }
                    currChars.remove(otherChar);
                    characterIndices.remove(otherChar);

                    ArrayList<Integer> prevCharIndices = characterIndices.get(prevChar);
                    ArrayList<Integer> newIndices = new ArrayList<>();
                    for(int i = prevCharIndices.size() - 1; i >= 0; i--){
                        int theIndex = prevCharIndices.get(i);
                        if(i == prevCharIndices.size() - 1){
                            newIndices.add(theIndex);
                        }else{
                            int theNextIndex = prevCharIndices.get(i + 1);
                            if(theNextIndex - theIndex == 1){
                                newIndices.add(theIndex);
                            }else{
                                break;
                            }
                        }
                    }
                    Collections.reverse(newIndices);
                    startPoint = newIndices.get(0);
                    characterIndices.put(prevChar, newIndices);
                    characterIndices.putIfAbsent(endChar, new ArrayList<>(Arrays.asList(endPoint)));
                    currChars.add(endChar);

                    if(result < (endPoint - startPoint + 1) && currChars.size() == 2){
                        result = endPoint - startPoint + 1;
                    }
                }
            }
            endPoint++;
        }

        return result;
    }

}
