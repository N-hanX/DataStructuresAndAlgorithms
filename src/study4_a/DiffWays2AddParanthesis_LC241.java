package study4_a;

import java.util.ArrayList;
import java.util.List;

public class DiffWays2AddParanthesis_LC241 {
    // not submitted, still exercising

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if(isExpressionNumber(expression)){
            result.add(Integer.parseInt(expression));
            return result;
        }

        int splitIndex = 0;
        while(splitIndex < expression.length()){
            if(isExpressionOperator(expression.charAt(splitIndex))){
                String leftPartOfExpression = expression.substring(0, splitIndex);
                String rightPartOfExpression = expression.substring(splitIndex + 1);

                List<Integer> leftResult = diffWaysToCompute(leftPartOfExpression);
                List<Integer> rightResult = diffWaysToCompute(rightPartOfExpression);

                for(int i = 0; i < leftResult.size(); i++){
                    for(int j = 0; j < rightResult.size(); j++){
                        System.out.println("expression: " + expression + " split index: " +  splitIndex + " left: " + leftResult.get(i) + " right: " + rightResult.get(j));
                        result.add(implementOperator(leftResult.get(i), rightResult.get(j), expression.charAt(splitIndex)));
                    }
                }
            }
            splitIndex++;
        }
        return result;
    }

    public static  int implementOperator(int leftNumber, int rightNumber, Character operator){
        if(operator == '+'){
            return leftNumber + rightNumber;
        }else if(operator == '-'){
            return leftNumber - rightNumber;
        }else if(operator == '*'){
            return leftNumber * rightNumber;
        }
        return Integer.MIN_VALUE;
    }

    public static  boolean isExpressionNumber(String expression){
        if((expression.length() == 1 && Character.isDigit(expression.charAt(0))) ||
                (expression.length() == 2 && Character.isDigit(expression.charAt(0)) && Character.isDigit(expression.charAt(1)))    ){
            return true;
        }
        return false;
    }

    public static boolean isExpressionOperator(Character expression){
        if(expression == '-' || expression == '+' || expression == '*'){
            return true;
        }
        return false;
    }

    static void main() {
        String expr = "2*30-4*5";
        List<Integer> res = diffWaysToCompute(expr);
        System.out.println(res);
    }
}
