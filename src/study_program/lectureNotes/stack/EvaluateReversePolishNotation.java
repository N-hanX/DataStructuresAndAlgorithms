package study_program.lectureNotes.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens1 = new String[]{"2","1","+","3","*"};
        String[] tokens2 = new String[]{"4","13","5","/","+"};
        String[] tokens3 = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int result1 = evalRPN(tokens1);
        int result2 = evalRPN(tokens2);
        int result3 = evalRPN(tokens3);
        int a = 5;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String curr_string = tokens[i];

            if(Character.isDigit(curr_string.charAt(0)) || (curr_string.length() > 1 && curr_string.charAt(0) == '-') ){
                Integer curr_number = Integer.valueOf(curr_string);
                nums.push(curr_number);
            }else{
                Character operand = curr_string.charAt(0);
                Integer num2 = nums.pop();
                Integer num1 = nums.pop();
                Integer result = null;

                if(operand == '+'){
                    result = num1 + num2;
                }
                if(operand == '-'){
                    result = num1 - num2;
                }
                if(operand == '/'){
                    result = num1 / num2;
                }
                if(operand == '*'){
                    result = num1 * num2;
                }
                nums.push(result);
            }
        }
        return nums.pop();
    }
}
