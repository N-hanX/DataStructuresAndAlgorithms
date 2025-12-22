package study_program.problemSet.linkedList_stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Implement_a_Min_Stack {
    public static void main(String[] args) {

//        ArrayList<Integer> operations = new ArrayList<>(Arrays.asList(10, 20, 30, 0, -1, 0, -1, 0));

        //10, 5, 0, -1, 0, -1, 0

//        ArrayList<Integer> operations = new ArrayList<>(Arrays.asList(10, 5, 0, -1, 0, -1, 0));
//        ArrayList<Integer> operations = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1));
        ArrayList<Integer> operations = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1));


        ArrayList<Integer> result = min_stack_v2(operations);
    }


    static ArrayList<Integer> min_stack(ArrayList<Integer> operations) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> min_stack_queue = new Stack<>();

        for(int i = 0; i < operations.size(); i++){
            int curr_operation = operations.get(i);

            if(curr_operation > 0){
                if(!min_stack_queue.isEmpty()){
                    curr_operation = Math.min(curr_operation, min_stack_queue.peek());
                }
                min_stack_queue.push(curr_operation);
            }else if(curr_operation == 0){
                if(!min_stack_queue.isEmpty()) {
                    int num = min_stack_queue.peek();
                    result.add(num);
                }else{
                    result.add(-1);
                }
            }else{
                min_stack_queue.pop();
            }
        }

        return result;
    }


    static ArrayList<Integer> min_stack_v2(ArrayList<Integer> operations) {
        // Write your code here.
        // 5 value           5 min
        // 5,4               5, 4
        // 5, 4 , 10         5, 4
        // 5, 4, 10, 11      5, 4
        // 5, 4, 10, 11, 2   5, 4,
        // min = 4
        // min = 2
        // 10, 5,  5
        // 10, 5, 5, 5
        // Maintain a mintack, where for every item, insert the min into the stack
        // since pop does not require to return
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> originalStack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();
        for(int op: operations) {
            // 10, 5
            // result = 5
            // 10,

            if(op >=1) {
                originalStack.add(op);
                if(minStack.isEmpty() || op < minStack.peek()) {
                    minStack.push(op);
                } else {
                    minStack.push(minStack.peek());
                }
            } else if(op == 0) {
                if(!minStack.isEmpty()) {
                    result.add(minStack.peek());
                } else {
                    result.add(-1);
                }
            } else if(op == -1) {
                if(!minStack.isEmpty()) {
                    minStack.pop();
                    originalStack.pop();
                }
            }
        }
        return result;

    }


}
