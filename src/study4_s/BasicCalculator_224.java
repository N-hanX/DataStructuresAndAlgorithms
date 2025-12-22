package study4_s;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator_224 {
    public static void main(String[] args) {

//        System.out.println(calculate("1 + 1"));            // Output: 2
//        System.out.println(calculate(" 2-1 + 2 "));        // Output: 3
        Solution s = new Solution();
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }


    static class Solution {

        public int calculate(String s) {
            Stack<String> evaluationStack = new Stack<>();
            List<String> listOfElements = new ArrayList<>();

            splitEvalution(s, listOfElements);

            return doEvaluation(listOfElements, evaluationStack);
        }

        public int doEvaluation(List<String> listOfElements, Stack<String> evaluationStack){
            for(String currElement: listOfElements){
                // operation priority // ignoring unary (minus) case
                // if there is multiplication or division first evaluationStack/
                // 2. if there is closed paranthesis do evaulation till the open paranthesis in Stack
                //
                if(!evaluationStack.isEmpty() && (evaluationStack.peek() == "*" || evaluationStack.peek() == "/")){
                    handleMultDivisionOperation(evaluationStack, currElement);
                }

                if(currElement.equals(")")){
                    handleWhenParanthesisClosed(evaluationStack);
                    continue;
                }
                evaluationStack.push(currElement);
            }

            // 3 + 4
            if(evaluationStack.size() == 1){
                return Integer.valueOf(evaluationStack.pop());
            }

            List<String> reversedOperations = new ArrayList<>();
            while(!evaluationStack.isEmpty()){
                reversedOperations.add(evaluationStack.pop());
            }

            List<String> lastOperations = new ArrayList<>();
            for(int i = reversedOperations.size() - 1; i >= 0; i--){
                lastOperations.add(reversedOperations.get(i));
            }


            // System.out.println("LAST OPERAT");
            for(String elemen: lastOperations){
                // System.out.println(elemen);
            }

            int ind = 0; // 2 - 1 + 2
            Integer prev_solution = null;

            while(ind < lastOperations.size()){
                if(prev_solution== null)
                    prev_solution = Integer.valueOf(lastOperations.get(ind));

                // System.out.println("prev solution: " + prev_solution);

                if(ind + 2 >= lastOperations.size()){
                    return prev_solution;
                }
                String operator = lastOperations.get(ind + 1);
                int secondElement = Integer.valueOf(lastOperations.get(ind + 2));

                if(operator.equals("+")){
                    prev_solution = prev_solution + secondElement;
                }else{
                    prev_solution = prev_solution - secondElement;
                }
                ind = ind + 2;
                // System.out.println("LAST solution: " + prev_solution);
            }

            return prev_solution;
        }

        // (3 + 5 * 6) => (3 + 30)
        public void handleWhenParanthesisClosed(Stack<String> evaluationStack){
            int subEvaluation = handleAddSubtOperation(evaluationStack);

            while(!evaluationStack.isEmpty() && !evaluationStack.peek().equals("(")){
                evaluationStack.push(""+ subEvaluation);
                subEvaluation = handleAddSubtOperation(evaluationStack);
            }
            if(!evaluationStack.isEmpty())
                evaluationStack.pop();
            evaluationStack.push(""+ subEvaluation);
        }

        public int handleAddSubtOperation(Stack<String> evaluationStack){
            String secondElement = evaluationStack.pop();
            String operation = evaluationStack.pop();

            if(operation.equals("(")){ // case: (1)
                evaluationStack.push("(");
                return Integer.valueOf(secondElement);
            }

            String firstElement = evaluationStack.pop();

            System.out.println(firstElement + "  " + operation + "  " + secondElement);
            int subEvaluation;
            if(operation.equals("-")){
                subEvaluation = Integer.valueOf(firstElement) - Integer.valueOf(secondElement);
            }else{
                subEvaluation = Integer.valueOf(firstElement) + Integer.valueOf(secondElement);
            }
            return subEvaluation;
        }


        public void handleMultDivisionOperation(Stack<String> evaluationStack, String currElement){
            String operation = evaluationStack.pop();
            int firstElementOfOper = Integer.valueOf(evaluationStack.pop());
            int subEvaluation;
            if(operation.equals("*")){
                subEvaluation = firstElementOfOper * Integer.valueOf(currElement);
            }else{
                subEvaluation = firstElementOfOper / Integer.valueOf(currElement);
            }
            evaluationStack.push("" + subEvaluation);
        }

        // number, space, operator, paranthesis, unary
        public void splitEvalution(String s, List<String> listOfElements){
            int moving_ind = 0;

            while(moving_ind < s.length()){
                moving_ind = getNonSpaceInd(s, moving_ind);

                if(isElementOperatorOrParanthesis(s, moving_ind)){
                    listOfElements.add("" + s.charAt(moving_ind));
                    moving_ind++;
                }

                StringBuilder digitBuilder = new StringBuilder();
                moving_ind = getIfThereIsNumber(digitBuilder, moving_ind, s);

                if(!digitBuilder.isEmpty()){
                    listOfElements.add(digitBuilder.toString());
                }
            }
        }

        public int getNonSpaceInd(String s, int moving_ind){
            while(moving_ind < s.length() && s.charAt(moving_ind) == ' '){ // space detected and pass all the space
                moving_ind++;
            }
            return moving_ind;
        }

        public boolean isElementOperatorOrParanthesis(String s, int moving_ind){
            if(moving_ind < s.length() && (s.charAt(moving_ind) == '+' || s.charAt(moving_ind) == '-' || s.charAt(moving_ind) == '*' || s.charAt(moving_ind) == '/' || s.charAt(moving_ind) == ')' || s.charAt(moving_ind) == '(' )){
                return true;
            }
            return false;
        }

        public int getIfThereIsNumber(StringBuilder digitBuilder, int moving_ind, String s){
            while(moving_ind < s.length() && Character.isDigit(s.charAt(moving_ind))) {
                digitBuilder.append(s.charAt(moving_ind));
                moving_ind++;
            }
            return moving_ind;
        }
    }
}
