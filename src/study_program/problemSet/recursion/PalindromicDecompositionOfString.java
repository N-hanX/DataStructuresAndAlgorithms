package study_program.problemSet.recursion;

import java.util.ArrayList;

public class PalindromicDecompositionOfString {
    public static void main(String[] args) {
//        String s = "abracadabra";
        // output: a|b|r|aca|d|a|b|r|a", "a|b|r|a|c|ada|b|r|a", "a|b|r|a|c|a|d|a|b|r|a

        // expected: ["a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a", "a|b|r|a|c|a|d|a|b|r|a"]
        String s = "aa";
        // expected: aa , a|a
        ArrayList<String> result = generate_palindromic_decompositions(s);

    }


    static ArrayList<String> generate_palindromic_decompositions(String s) {
        ArrayList<String> result = new ArrayList<String>();
        search_palindrome(s, 0, s.length() - 1, new StringBuilder(), result);
        return result;
    }

    static void search_palindrome(String s, int startInd, int endInd, StringBuilder builder,
                                               ArrayList<String> result) {
        if(endInd >= s.length() || startInd >= s.length()){
            result.add(builder.toString());
            return;
        }

        // ya startInd'e dahil edersin

        int palindromeEndInd = startInd + 1;
        while(palindromeEndInd < s.length()){
            if(isPalindrome(s, startInd, palindromeEndInd)){
                if(startInd != 0)
                    builder.append("|");
                builder.append(s, startInd, palindromeEndInd + 1);
                search_palindrome(s, palindromeEndInd + 1, endInd, builder, result);
                int addedStringSize;
                if(startInd != 0)
                    addedStringSize = 1 + (palindromeEndInd - startInd + 1);
                else
                    addedStringSize = palindromeEndInd - startInd + 1;

                builder.delete(builder.length() - addedStringSize, builder.length());
            }
            palindromeEndInd++;
        }

        // ya startInd'e dahil etmezsin

        if(startInd != 0)
            builder.append("|");
        builder.append(s.charAt(startInd));
        search_palindrome(s, startInd + 1, endInd, builder, result);

        if(startInd != 0)
            builder.delete(builder.length() - 2, builder.length());
        else
            builder.delete(builder.length() - 1, builder.length());
    }

    static Boolean isPalindrome(String s, int startInd, int endInd){
        while(startInd <= endInd){
            if(s.charAt(startInd) == s.charAt(endInd)){
                startInd++;
                endInd--;
            }else{
                return false;
            }
        }
        return true;
    }

}
