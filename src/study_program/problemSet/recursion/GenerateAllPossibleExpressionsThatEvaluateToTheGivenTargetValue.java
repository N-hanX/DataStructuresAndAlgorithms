package study_program.problemSet.recursion;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateAllPossibleExpressionsThatEvaluateToTheGivenTargetValue {
    public static void main(String[] args) {
//        String s = "325387";
//        Long target = 133L;

//        String s = "202";
//        Long target = 4L;

        String s = "6666666666666";
        Long target = 6L;

        generate_all_expressions(s, target);
    }

    static ArrayList<String> generate_all_expressions(String s, Long target) {
        ArrayList<String> result = new ArrayList<String>();

        generateExpression(s, 0, new StringBuilder(), result, target);

        return result;
    }

    static Boolean isTheExpressionTarget(String currResult, Long target){
//        if(!currResult.equals("3*2+5*3*8+7")){
//            return false;
//        }

        Stack<String> expressionStack = new Stack<>();

        int currIndex = 0;
        int startInd = currIndex;
        int endInd = currIndex;
        while (endInd < currResult.length() && (!String.valueOf(currResult.charAt(endInd)).equals("*") &&
                !String.valueOf(currResult.charAt(endInd)).equals("+"))) {
            endInd++;
        }
        String newCharacter;
        if(startInd == endInd){
            newCharacter = currResult.substring(startInd, endInd + 1);
            currIndex++;
        }else{
            newCharacter = currResult.substring(startInd, endInd);
            currIndex = endInd;
        }

        expressionStack.add(newCharacter);

        while(expressionStack != null){
            String topCharacter = expressionStack.peek();

            if(topCharacter.equals("*")){
                startInd = currIndex;
                endInd = currIndex;
                while(endInd < currResult.length() && (!String.valueOf(currResult.charAt(endInd)).equals("*") &&
                        !String.valueOf(currResult.charAt(endInd)).equals("+"))){
                    endInd++;
                }

                if(startInd == endInd){
                    newCharacter = currResult.substring(startInd, endInd + 1);
                    currIndex++;
                }else{
                    newCharacter = currResult.substring(startInd, endInd);
                    currIndex = endInd;
                }

                Long result;
                expressionStack.pop();
                Long topValue = Long.valueOf(expressionStack.pop());
                result = Long.valueOf(newCharacter) * topValue;
                expressionStack.add(Long.toString(result));
            }else{
                if(currIndex != currResult.length()){
                    if(currResult.charAt(currIndex) != '+' && currResult.charAt(currIndex) != '*') {
                        startInd = currIndex;
                        endInd = currIndex;
                        while (endInd < currResult.length() && (!String.valueOf(currResult.charAt(endInd)).equals("*") &&
                                !String.valueOf(currResult.charAt(endInd)).equals("+"))) {
                            endInd++;
                        }
                        if(startInd == endInd){
                            newCharacter = currResult.substring(startInd, endInd + 1);
                            currIndex++;
                        }else{
                            newCharacter = currResult.substring(startInd, endInd);
                            currIndex = endInd;
                        }
                        expressionStack.add(newCharacter);
                    }else{
                        newCharacter = String.valueOf(currResult.charAt(currIndex));
                        expressionStack.add(newCharacter);
                        currIndex++;
                    }
                }else{// it means the end Of char
                    Long topValue = Long.valueOf(expressionStack.pop());
                    Long intermediateResult;

                    if(!expressionStack.isEmpty()){// it should be plus
                        expressionStack.pop();
                        Long theOtherValue = Long.valueOf(expressionStack.pop());
                        intermediateResult = topValue + theOtherValue;
                        expressionStack.add(String.valueOf(intermediateResult));
                    }else{
                        if(topValue.equals(target)){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    static void generateExpression(String s, int currIndex, StringBuilder stringBuilder, ArrayList<String> result,
                                   Long target){
        if(currIndex == s.length()){
            String currResult = stringBuilder.toString();

            if(isTheExpressionTarget(currResult, target))
                result.add(currResult);
            return;
        }

        stringBuilder.append(s.charAt(currIndex));
        generateExpression(s, currIndex + 1, stringBuilder, result, target);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        if(currIndex > 0) {
            stringBuilder.append("+");
            stringBuilder.append(s.charAt(currIndex));
            generateExpression(s, currIndex + 1, stringBuilder, result, target);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            stringBuilder.append("*");
            stringBuilder.append(s.charAt(currIndex));
            generateExpression(s, currIndex + 1, stringBuilder, result, target);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
