package study_program.problemSet.linkedList_stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LongestSubstringWithBalancedParentheses_v2 {
    public static void main(String[] args) {
//        String str1 = "((((())(((()";
//        String str1 = "()()()";
//        String str1 = "(((())))";
        String str1 = "()((()))()((()))";
//        String str1 = "()(()";
        int result = find_max_length_of_matching_parentheses(str1);
        int a =4;
    }

    static class Bracket{
        int startIndex;
        int endIndex;
        public Bracket(int startIndex, int endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public static Integer find_max_length_of_matching_parentheses(String brackets) {
        Stack<Integer> bracketStack = new Stack<>();

        ArrayList<Integer> balancedBrackets = new ArrayList<>();

        int max_counter = 0;
        int counter = 0;
        for(int i = 0; i < brackets.length(); i++){
            char c = brackets.charAt(i);
            if(c == '(')
                bracketStack.push(i);
            else{
                if(!bracketStack.isEmpty()){
                    balancedBrackets.add(i);
                    balancedBrackets.add(bracketStack.peek());
                    bracketStack.pop();
                }
            }
        }
        Collections.sort(balancedBrackets);

        int i = 0;

        while(i < balancedBrackets.size()){

            counter = counter + 1;
            while(i + 1 != balancedBrackets.size() && balancedBrackets.get(i + 1) - balancedBrackets.get(i) <= 1 ){
                counter = counter + 1;
                if(balancedBrackets.get(i + 1) - balancedBrackets.get(i) <= 1)
                    i++;
            }
            if(max_counter < counter)
                max_counter = counter;
            counter = 0;

            i++;
        }
        return max_counter;
    }

}
