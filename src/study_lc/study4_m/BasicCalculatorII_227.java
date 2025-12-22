package study_lc.study4_m;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculatorII_227 {
    public static void main(String[] args) {

//        int result = calculate("3+2*2");
        //
        int result2 = calculate(" 3+5 / 2 ");
        int a = 4;
    }

    static int INTEGER_MODE = 0;
    static int OPERATOR_MODE = 1;

    public static int calculate(String s) {
        Stack<String> expr_stack = new Stack<>();

        int mode = INTEGER_MODE;

        for(int i = 0; i < s.length(); i++){
            System.out.println("i " + i);
            if(mode == INTEGER_MODE){
                int curr_ind = i;
                StringBuilder int_builder = new StringBuilder();

                while(curr_ind < s.length()){
                    char curr_char = s.charAt(curr_ind);
                    if(Character.isDigit(curr_char) || curr_char == ' '){
                        int_builder.append(s.charAt(curr_ind));
                        i = curr_ind;
                    }else{
                        break;
                    }
                    curr_ind++;
                }

                String int_str = int_builder.toString().trim();
                int_str = int_str.trim();
                System.out.println("str : " + int_str);
                if(!int_str.isEmpty()){
                    int val = Integer.parseInt(int_str);

                    if(!expr_stack.isEmpty() && (expr_stack.peek().equals("*") || expr_stack.peek().equals("/") )){
                        String operator = expr_stack.pop();
                        System.out.println("operator: " + operator);
                        int first_val = Integer.parseInt(expr_stack.pop());

                        if(operator.equals("*")){
                            int curr_result = first_val * val;
                            expr_stack.push(String.valueOf(curr_result));
                            System.out.println("curr result: " + curr_result);
                        }else{
                            int curr_result = first_val / val;
                            expr_stack.push(String.valueOf(curr_result));
                            System.out.println("curr result: " + curr_result);
                        }
                    }else{
                        expr_stack.push(String.valueOf(val));
                    }
                }
                mode = OPERATOR_MODE;
            }else{
                StringBuilder operator = new StringBuilder();
                int curr_ind = i;

                while(curr_ind < s.length()){
                    char curr_char = s.charAt(curr_ind);

                    if(curr_char == '*' || curr_char == '/' || curr_char == '-' || curr_char == '+' ||  curr_char == ' ' ){
                        operator.append(curr_char);
                        i = curr_ind;
                    }else{
                        break;
                    }
                    curr_ind++;
                }

                String int_str = operator.toString().trim();
                if(!int_str.isEmpty())
                    expr_stack.push(int_str);

                mode = INTEGER_MODE;
            }
        }

        ArrayList<String> resultList = new ArrayList<>();
        resultList.addAll(expr_stack);

        if(resultList.size() == 1){
            return Integer.parseInt(resultList.get(0));
        }

        int result = 0;
        String prevOperator = "";
        System.out.println("ey");
        mode = INTEGER_MODE;
        for(int i = 0; i < resultList.size(); i++){
            String val = resultList.get(i);
            System.out.println(val);

            if(mode == INTEGER_MODE){
                if(i == 0){
                    result = Integer.parseInt(val);
                }else{
                    char curr_char = prevOperator.charAt(0);
                    System.out.println("val: " + val);
                    if(curr_char == '-' ){
                        result = result - Integer.parseInt(val);
                    }else{
                        result = result + Integer.parseInt(val);
                    }
                }
                mode = OPERATOR_MODE;
            }else{
                System.out.println("val2: " + val);
                prevOperator = val;
                mode = INTEGER_MODE;
            }
        }

        return result;
    }
}
