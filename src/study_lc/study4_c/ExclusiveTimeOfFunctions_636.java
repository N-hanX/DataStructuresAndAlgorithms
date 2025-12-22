package study_lc.study4_c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions_636 {
    public static void main(String[] args) {
//        int n = 2;
//        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));

//        int n = 1;
//        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));

        int n = 2;
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"));

        int[] result = exclusiveTime(n, logs);

        int a = 4;
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        Stack<Integer> funcStack = new Stack<>();
        int prev_time = 0;

        for(int i = 0; i < logs.size(); i++){
            String curr_log = logs.get(i);
            String[] parts = curr_log.split(":");
            int func_id = Integer.valueOf(parts[0]);
            String operation = parts[1];
            int curr_time = Integer.valueOf(parts[2]);

            if(operation.equals("start")){
                // update top func processing time in result;

                if(!funcStack.isEmpty()){
                    int peek_func = funcStack.peek();
                    result[peek_func] += curr_time - prev_time;
                    // System.out.println("curr time update: peek func_id " + peek_func + " | total processing "  +result[peek_func]);
                }else{
                    //  System.out.println("first function");
                }

                funcStack.push(func_id);
                prev_time = curr_time;
            }else{
                // should be consistent with top element
                if(!funcStack.isEmpty() && funcStack.peek() == func_id){
                    result[func_id] += curr_time - prev_time + 1;
                    // System.out.println("end time update: func_id " + func_id + " | total processing "  + result[func_id]);
                    funcStack.pop();
                }else{
                    // System.out.println("There might be inconsistency");
                }
                prev_time = curr_time + 1;
            }
        }
        return result;
    }
}
