package study4_a;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumAdd2MakeParanthesesValid_921 {
    static void main() {
        // TEST 1
//        String s = "())";
//        int result = minAddToMakeValid_v1(s);

        // TEST 2
//        String s = "(((";
//        int result = minAddToMakeValid_v1(s);
//
//        // TEST 3
//        String s = "()))((";
//        int result = minAddToMakeValid_v1(s);


        // OTHER VERSION
        // TEST 1
//        String s = "())";
//        int result = minAddToMakeValid_v2(s);

        // TEST 2
//        String s = "(((";
//        int result = minAddToMakeValid_v2(s);
//
//        // TEST 3
        String s = "()))((";
        int result = minAddToMakeValid_v2(s);

        int a = 4;

    }

    // Easy to understand version. Uses a common stack logic similar to operator precedence problems.
    public static int minAddToMakeValid_v2(String s) {
        Deque<Character> paranthesisStack = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            char curr_char = s.charAt(i);

            if(curr_char == '('){
                paranthesisStack.push(curr_char);
            }else{
                if(!paranthesisStack.isEmpty() && paranthesisStack.peek() == '('){
                    paranthesisStack.pop();
                }else{
                    paranthesisStack.push(curr_char);
                }
            }
        }
        return paranthesisStack.size();
    }

    public static int minAddToMakeValid_v1(String s) {
        int leftParanthesis = 0;
        int rightParanthesis = 0;

        for(int i = 0; i < s.length(); i++){
            char curr_char = s.charAt(i);

            // first approach: count left and right ones, and get abs differences
            // but it fails in this case "()))(("  the result gets zero though it is not correct.
            // for this reason it requires to handle the priority of paranthesis
            // the first requirement the expression needs left paranthesis as much as right paranthesis while traversing the expression
            // for this reason we need to count left ones whenever we encounter. this is the part of the result
            // when there is right, if there is already some left counted before we can decrease counted left with these rights
            // but if there is no left, then we need to count the right ones because absence of left doesn't compensate right. so we definitely have to consider them.
            //
            if(curr_char == '('){
                leftParanthesis++;
            }else {
                if(leftParanthesis > 0){
                    leftParanthesis--;
                }
                else{
                    rightParanthesis++;
                }
            }
        }
        return leftParanthesis + rightParanthesis;
    }
}
