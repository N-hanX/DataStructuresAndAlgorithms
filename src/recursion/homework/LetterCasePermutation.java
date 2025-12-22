package recursion.homework;

import java.util.ArrayList;

public class LetterCasePermutation {
    public static void main(String[] args) {

        letter_case_permutations("a1z");

    }

    static ArrayList<String> letter_case_permutations(String s) {
        ArrayList<String> result = new ArrayList<>();
        int currInd = 0;
        StringBuilder stringBuilder = new StringBuilder();
        permuteString(s, result, currInd,stringBuilder);

        return result;
    }

    static void permuteString(String s,ArrayList<String> result,  int ind, StringBuilder currPerm){
        if(s.length() == ind){
            result.add(currPerm.toString());
            return;
        }

        char c = s.charAt(ind);
        if(!Character.isDigit(c)){
            c = Character.toLowerCase(c);
            currPerm.append(c);
            permuteString(s, result, ind + 1, currPerm);
            currPerm.deleteCharAt(ind);

            c = Character.toUpperCase(c);
            currPerm.append(c);
            permuteString(s, result, ind + 1, currPerm);
            currPerm.deleteCharAt(ind);
        }else{
            currPerm.append(c);
            permuteString(s, result, ind + 1, currPerm);
            currPerm.deleteCharAt(ind);
        }
    }
}
