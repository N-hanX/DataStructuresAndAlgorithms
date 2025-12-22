package study_program.problemSet.linkedList_stack_queue;

import java.util.ArrayList;
import java.util.Stack;

public class LongestSubstringWithBalancedParentheses {
    public static void main(String[] args) {
//        "brackets": "((((())(((()"
        // ((((  -> ((( > ((  -> (( ((((
        // ++ , ++ return 4 dedik sonra eklemeye devam ettik () 2 oldu
        //()()()
        // (
        // ()
        //  ya vardir yada yoktur
        // eger ki soyle olsaydi ((((())(((()))) - >8 olurdu

        //((((())(((()))))) -> 16 olurdu

//        String brackets = "((((())(((()";
//        String brackets = "()()()";
        String brackets = "abcd";
        Integer result = find_max_length_of_matching_parentheses(brackets);

        // 5 -2 4 -1
        // 4 // 2
        // 5 -2 4 -1
        int a = 5;

    }


    static Integer find_max_length_of_matching_parentheses(String brackets) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);

        recursiveBrackets(brackets, result, new StringBuilder(), 0, brackets.length());
        return result.get(0);
    }


    static void recursiveBrackets(String brackets, ArrayList<Integer> result,
                                  StringBuilder stringBuilder, int currInd, int endInd){

        System.out.println(stringBuilder.toString());
        if(!stringBuilder.isEmpty() && isBalanced(stringBuilder.toString())){
            if(result.get(0) < stringBuilder.toString().length()){
                result.set(0, stringBuilder.toString().length());
            }
//            return;
        }

        if(currInd >= brackets.length())
            return;

        for(int i = currInd + 1; i <= endInd; i++) {
            stringBuilder.append(brackets, currInd, i);
            recursiveBrackets(brackets, result, stringBuilder, currInd + 1, i);
            stringBuilder.delete(stringBuilder.length() - (i - currInd), stringBuilder.length());
            recursiveBrackets(brackets, result, stringBuilder, currInd + 1, i);
        }
    }

    static Boolean isBalanced(String string){
        if(string.equals("((()))")){
            int a = 5;
        }
        Stack<Character> brackets = new Stack<>();

        int countInd = 0;

        while(countInd < string.length()){
            char curr_char = string.charAt(countInd);

            if(curr_char == '('){
                brackets.add('(');
            }else if(curr_char == ')'){

                if(!brackets.isEmpty()){
                    char last_char = brackets.peek();

                    if(last_char == '(')
                        brackets.pop();
                    else{
                        brackets.push('(');
                    }
                }else{
                    brackets.push('(');
                }
            }
            countInd++;
        }

        if(brackets.isEmpty())
            return true;

        return false;
    }

}
