package dynamics;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {
    public static void main(String[] args) {
        ArrayList<String> dicts = new ArrayList<>(Arrays.asList("world", "hello", "faang"));
        String str = "helloworldhellox";
        Boolean result = word_break(str, dicts);
        int a = 5;
    }

    static Boolean word_break(String s, ArrayList<String> words_dictionary) {
        int[][] dpTable = new int[words_dictionary.size() + 1][s.length() + 1];
        for(int i = 0; i < dpTable.length; i++){
            for(int j = 0; j < dpTable[0].length; j++){
                if(j == 0)
                    dpTable[i][j] = 1;
                else
                    dpTable[i][j] = -1;

            }
        }

        words_dictionary.add(0, "");
        int result = find_word_break(s, words_dictionary, dpTable);
        if(result == 1)
            return true;
        return false;
    }

    static int find_word_break(String sentence, ArrayList<String> words_dictionary,
                               int[][] dpTable) {

        for(int i = 1; i <= sentence.length(); i++){
            for(int dict_Index = 0; dict_Index < words_dictionary.size(); dict_Index++){

                String currSubSentence = sentence.substring(0, i);
                String currWord = words_dictionary.get(dict_Index);

                dpTable[dict_Index][i] = 0;

                if(currSubSentence.endsWith(currWord)){
                    int subSentenceWithoutCurrentWordIndex = currSubSentence.length() - currWord.length();
                    if(subSentenceWithoutCurrentWordIndex >= 0 && dpTable[words_dictionary.size() - 1][subSentenceWithoutCurrentWordIndex] == 1){
                        dpTable[dict_Index][i] = 1;
                    }else{
                        dpTable[dict_Index][i] = 0;
                    }
                }
                if(dict_Index > 0 && dpTable[dict_Index-1][i] == 1){
                    dpTable[dict_Index][i] = 1;
                }
            }
        }
        return dpTable[words_dictionary.size() - 1][sentence.length()];

    }
}
