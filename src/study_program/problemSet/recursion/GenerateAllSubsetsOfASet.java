package study_program.problemSet.recursion;

import java.util.ArrayList;

public class GenerateAllSubsetsOfASet {
    public static void main(String[] args) {

        String s = new String("xy");
        ArrayList<String> result = generate_all_subsets(s);
        int a = 5;
    }


    static ArrayList<String> generate_all_subsets(String s) {
        ArrayList<String> result = new ArrayList<>();
        subset_generator(s, new StringBuilder(), result,0);

        return result;
    }

    static void subset_generator(String s, StringBuilder stringBuilder, ArrayList<String> result, int currIndex) {
        if(currIndex >= s.length()){
            String newString = stringBuilder.toString();
            result.add(newString);

            return;
        }

        char currChar = s.charAt(currIndex);
        subset_generator(s, stringBuilder.append(currChar), result, currIndex + 1);
        subset_generator(s, stringBuilder.deleteCharAt(stringBuilder.length() - 1), result, currIndex + 1);
    }
}
