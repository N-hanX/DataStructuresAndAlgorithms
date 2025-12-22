package study_program.problemSet.string;

import java.util.ArrayList;

public class KMP {
    public static void main(String[] args) {
        String pattern = "abcaby";
        String word = "abxabcabcaby";

//        AABAACAADAABAABA
//        AABA
//        String pattern = "AABA";
//        String word = "AABAACAADAABAABA";

        ArrayList<Integer> result = searchPattern(word, pattern);
        int a = 4;
    }

    public static ArrayList<Integer> searchPattern(String word, String pattern){
        // preprocess pattern
        int patterLen = pattern.length();

        ArrayList<Integer> result = new ArrayList<>();

        int[] longestPrefixSuffix = new int[pattern.length()];

        int i = 0;
        int j;
        while(i < patterLen){
            j = i + 1;
            while(j < patterLen){
                if(pattern.charAt(i) == pattern.charAt(j)){
                    longestPrefixSuffix[j] = i + 1;
                    break;
                }else{
                    j++;
                }
            }
            i++;
        }

        int wordLen = word.length();
        int wordInd = 0;

        int patternInd = 0;
        while(wordInd < wordLen){
            if(word.charAt(wordInd) == pattern.charAt(patternInd)){
                patternInd++;
                wordInd++;
                if(patternInd == patterLen){
                    result.add(wordInd - patternInd);
                    patternInd = longestPrefixSuffix[patternInd - 1];
                }
            }else{
                if(patternInd >= 1)
                    patternInd = longestPrefixSuffix[patternInd - 1];
                else
                    patternInd = 0;

                if(word.charAt(wordInd) == pattern.charAt(patternInd)){
                    wordInd++;
                    patternInd++;
                    if(patternInd == patterLen){
                        result.add(wordInd - patternInd);
                        patternInd = longestPrefixSuffix[patternInd - 1];
                    }
                }else{
                    wordInd++;
                }
            }
        }
            if(result.isEmpty()){
                result.add(-1);
            }

        return result;
    }
}
