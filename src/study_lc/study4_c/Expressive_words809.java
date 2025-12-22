package study_lc.study4_c;

import java.util.ArrayList;
import java.util.List;

public class Expressive_words809 {
    public static void main(String[] args) {
//        String s = "heeellooo";
//        String[] words = new String[]{"hello", "hi", "helo"};

        String s = "zzzzzyyyyy";
        String[] words = new String[]{"zzyy","zy","zyy"};

        int result = expressiveWords(s, words);

        int a = 4;
    }

    static List<Character> string_charListByRespectively;
    static List<Integer> string_charNumByRespectively;

    public static int expressiveWords(String s, String[] words) {
        string_charListByRespectively = new ArrayList<>(100);
        string_charNumByRespectively = new ArrayList<>(100);
        calculateStringInfo(s);
        int result_counter = 0;

        for(int i = 0; i < words.length; i++){
            String word = words[i];

            int index_counter = 0;
            int char_equality_counter = 0;

            boolean expressive = true;
            while(index_counter < word.length()){
                char curr_char = word.charAt(index_counter);
                int char_counter = 1;

                while(index_counter + 1 < word.length()){
                    if(curr_char == word.charAt(index_counter + 1)){
                        char_counter++;
                        index_counter++;
                        if(index_counter + 1 == word.length()){
                            break;
                        }
                    }else{
                        break;
                    }
                }
                // System.out.println("index counter: " + index_counter);
                // System.out.println("word char: " + i + ": " + curr_char + " : " + char_counter);

                if(char_equality_counter >= string_charListByRespectively.size() ||
                        string_charListByRespectively.get(char_equality_counter) != curr_char){
                    expressive = false;
                    break;
                }else{
                    int char_num_in_string = string_charNumByRespectively.get(char_equality_counter);
                    if(char_num_in_string == char_counter){

                    }else if(char_num_in_string < 3){
                        expressive = false;
                        break;
                    }else if(char_num_in_string < char_counter){
                        expressive = false;
                        break;
                    }
                }
                index_counter++;
                char_equality_counter++;
            }
            // System.out.println("equal chars:" + char_equality_counter);
            // System.out.println("string_charListByRespectively:" + string_charListByRespectively.size())
            // ;

            if(char_equality_counter != string_charListByRespectively.size()){
                expressive = false;
            }

            if(expressive == true){
                result_counter++;
            }
        }
        return result_counter;
    }

    public static void calculateStringInfo(String s){
        int running_index = 0;
        int char_counter = 0;

        while(running_index < s.length()){
            if(running_index == 0){
                // System.out.println("a");
                running_index++;
                char_counter++;
                continue;
            }else{
                if(s.charAt(running_index) == s.charAt(running_index - 1)){
                    // System.out.println("b");
                    running_index++;
                    char_counter++;
                }else{
                    // System.out.println("c");
                    // System.out.println("char:" + s.charAt(running_index - 1) + ":" + char_counter);
                    string_charListByRespectively.add(s.charAt(running_index - 1));
                    string_charNumByRespectively.add(char_counter);
                    running_index++;
                    char_counter = 1;
                }
            }
        }
        // System.out.println("char:" + s.charAt(running_index - 1) + ":" + char_counter);
        string_charListByRespectively.add(s.charAt(running_index - 1));
        string_charNumByRespectively.add(char_counter);
    }
}
