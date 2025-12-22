package study_program.problemSet.linkedList_stack_queue;

import java.util.Stack;

public class ValidExpression {
    public static void main(String[] args) {
        String expression = "{(1+2)*3}+4";
//        String expression = "((1+2)*3*)";
//        String expression = "()()[]{}";
//        String expression = "}";
//        String expression = "{2+1+(3+4)}";
//        String expression = "1+2+[3*4]+5";
//        String expression = "3(2)+";
//        String expression = "{[(1*2*3*4)+(5+6+7+8)]}";

        Boolean result = is_valid(expression);
        int a = 5;
    }

    static Boolean is_valid(String expression) {
        Stack<Character> operand_brackets = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        for(int i  = 0; i < expression.length(); i++){
            char c = expression.charAt(i);

            if(c == ')' || c == '}' || c == ']'){
                if(!operand_brackets.isEmpty() && (operand_brackets.peek() == '+' || operand_brackets.peek() == '-' ||
                        operand_brackets.peek() == '*') && !numbers.isEmpty() && numbers.size() == 2){
                    int num1 = numbers.pop();
                    int num2 = numbers.pop();

                    int result;
                    if (operand_brackets.peek() == '+') {
                        result = num1 + num2;
                    } else if (operand_brackets.peek() == '-') {
                        result = num2 - num1;
                    } else {
                        result = num1 * num2;
                    }
                    operand_brackets.pop();
                    numbers.push(result);
                }
            }

            if(c == '(' || c == ')' || c == '{' || c == '}' || c == '+' ||
                    c == '-' || c == '*' || c == '[' || c == ']'){
                if(c == '(' || c == '{' || c == '[') {
                    if(operand_brackets.isEmpty() && !numbers.isEmpty()){
                        return false;
                    }
                    operand_brackets.push(c);
                }
                else if(c == ')'){
                    if(operand_brackets.isEmpty() || operand_brackets.peek() != '(')
                        return false;
                    else
                        operand_brackets.pop();
                }else if(c == '}'){
                    if(operand_brackets.isEmpty() || operand_brackets.peek() != '{')
                        return false;
                    else
                        operand_brackets.pop();
                }else if(c == ']'){
                    if(operand_brackets.isEmpty() || operand_brackets.peek() != '[')
                        return false;
                    else
                        operand_brackets.pop();
                }else{
                    operand_brackets.push(c);
                }
            }else{
                if(numbers.isEmpty() || operand_brackets.peek() == '(' || operand_brackets.peek() == '[' ||
                        operand_brackets.peek() == '{' )
                    numbers.push(Character.getNumericValue(c));
                else{
                    int newNumber = Character.getNumericValue(c);
                    int lastNumber = numbers.peek();

                    if(operand_brackets.peek() == '+' || operand_brackets.peek() == '-' ||
                            operand_brackets.peek() == '*' ) {
                        int result;

                        if (operand_brackets.peek() == '+') {
                            result = newNumber + lastNumber;
                        } else if (operand_brackets.peek() == '-') {
                            result = lastNumber - newNumber;
                        } else {
                            result = newNumber * lastNumber;
                        }
                        operand_brackets.pop();
                        numbers.pop();
                        numbers.push(result);
                    }
                }
            }
        }

        if(!operand_brackets.isEmpty() && (operand_brackets.peek() == '+' || operand_brackets.peek() == '-' ||
                operand_brackets.peek() == '*') && !numbers.isEmpty() && numbers.size() == 2){
            int num1 = numbers.pop();
            int num2 = numbers.pop();

            int result;
            if (operand_brackets.peek() == '+') {
                result = num1 + num2;
            } else if (operand_brackets.peek() == '-') {
                result = num2 - num1;
            } else {
                result = num1 * num2;
            }
            operand_brackets.pop();
            numbers.push(result);
        }


        if(operand_brackets.isEmpty() && (numbers.size() == 1 || numbers.isEmpty()))
            return true;

        return false;
    }
}
