package study_lc.study4_c;

import java.util.Stack;

public class ReverseWordsInString_151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String result = reverseWords(s);
        int a = 4;
    }

    public static String reverseWords(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder curr_word = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char curr_char = s.charAt(i);

            if(curr_char == ' '){
                if(!curr_word.isEmpty()){
                    stack.push(curr_word.toString());
                    curr_word = new StringBuilder();
                }
            }else{
                curr_word.append(curr_char);
            }
        }

        if(!curr_word.isEmpty()){
            stack.push(curr_word.toString());
        }
        StringBuilder result = new StringBuilder();
        int counter = 0;
        while(!stack.isEmpty()){
            result.append(stack.pop());
            if(stack.size() >= 1){
                result.append(" ");
            }
        }
        return result.toString();
    }
}
