package study_program.lectureNotes.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation_Prefix {
    public static void main(String[] args) {
        String[] tokens1 = new String[]{"*","+","2","1","3"};
        String[] tokens2 = new String[]{"+", "4","/", "13","5"};
        String[] tokens3 = new String[]{"+","+","*","10","/","6","*","+","9","3","-11","17","5"};

        int result1 = evalRPN(tokens1);
        int result2 = evalRPN(tokens2);
        int result3 = evalRPN(tokens3);
        int a = 5;
    }

    public static boolean isInteger(String curr_string){
        if(Character.isDigit(curr_string.charAt(0)) || (curr_string.length() > 1 && curr_string.charAt(0) == '-') )
            return true;
        return false;
    }

    public static int evaluate(int num1, int num2, char operand){
        if(operand == '+'){
            return num1 + num2;
        }
        if(operand == '-'){
            return num1 - num2;
        }
        if(operand == '/'){
            return num1 / num2;
        }
        if(operand == '*'){
            return num1 * num2;
        }
        return Integer.MIN_VALUE;
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> elements = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            String curr_string = tokens[i];

            String theTopElement;
            if(!elements.isEmpty() && isInteger(curr_string)){
                theTopElement = elements.peek();
                int num2 = Integer.valueOf(curr_string);

                if(!isInteger(theTopElement)){
                    elements.push(curr_string);
                    continue;
                }


                while(isInteger(theTopElement)){
                    int num1 = Integer.valueOf(elements.pop());
                    char operand = elements.pop().charAt(0);

                    int result = evaluate(num1, num2, operand);

                    theTopElement = null;
                    if(!elements.empty())
                        theTopElement = elements.peek();


                    if(theTopElement != null && isInteger(theTopElement)){
                        num2 = result;
                        continue;
                    }else{
                        elements.push(Integer.toString(result));
                        break;
                    }
                }
            }else
                elements.push(curr_string);
        }
        return Integer.valueOf(elements.pop());
    }
}
