package recursion.homework;

import java.util.*;

public class SubsetsWithDuplicateCharacters {
    public static void main(String[] args) {
        String s = "fdsf";

        get_distinct_subsets(s);


    }
    static ArrayList<String> get_distinct_subsets(String s) {
        ArrayList<Character> charList = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            charList.add(s.charAt(i));
        }

        Collections.sort(charList);

        StringBuilder sortedStrBuilder = new StringBuilder();

        Set<String> subsets = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        createPerm_2(charList, subsets, result, sortedStrBuilder);

        return result;
    }

    static void createPerm(String str, int startInd, int endInd, Set<String> subsets, ArrayList<String> result){

        if( str.length() == 0 || startInd < 0 || startInd > str.length() || endInd < 0 || endInd > str.length() || startInd > endInd){
            return;
        }
        String currPermStr = str.substring(startInd, endInd);

        for(int i = 0; i < str.length() ; i++){
            subsets.add(currPermStr);
            createPerm(currPermStr, i + 1, str.length(), subsets, result);
            createPerm(currPermStr, i, str.length() - 1, subsets, result);
        }
    }

    static void createPerm_2(ArrayList<Character> chars, Set<String> subsets, ArrayList<String> result,
                             StringBuilder currPermBuilder){
        if(chars.size() == 0){
            String currStr = currPermBuilder.toString();
            result.add(currStr);
            return;
        }

        for(int i = 0; i < chars.size() ; i++){
            char curr_char = chars.get(i);
            currPermBuilder.append(curr_char);
            chars.remove(i);
            createPerm_2(chars, subsets, result, currPermBuilder);
            currPermBuilder.delete(currPermBuilder.length() - 1, currPermBuilder.length());
            createPerm_2(chars, subsets, result, currPermBuilder);
            chars.add(i, curr_char);
        }
    }
}
