package study_program.problemSet.recursion;

import java.util.ArrayList;

public class StringsFromWildCard {
    public static void main(String[] args) {
//        String s = "1?10";
        String s = "1?0?";
        find_all_possibilities(s);
        int a = 5;
    }

    static ArrayList<String> find_all_possibilities(String s) {

        StringBuilder builder = new StringBuilder();
        int currInd = 0;
        ArrayList<String> result = new ArrayList<>();

        helper(builder, currInd, s, result);
        return result;
    }

    static void helper(StringBuilder builder, int currInd, String s, ArrayList<String> result) {
        if(s.length() == currInd){
            result.add(builder.toString());
            return;
        }

        char currChar = s.charAt(currInd);
        if(currChar == '?'){
            builder.append('0');
            helper(builder, currInd + 1, s, result);

            builder.delete(currInd, builder.length());

            builder.append('1');
            helper(builder, currInd + 1, s, result);

            builder.delete(currInd, builder.length());
        }else{
            builder.append(currChar);
            helper(builder, currInd + 1, s, result);
        }
    }
}
