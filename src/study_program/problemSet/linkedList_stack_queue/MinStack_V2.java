package study_program.problemSet.linkedList_stack_queue;

import java.util.*;

public class MinStack_V2 {
    public static void main(String[] args) {
//        ArrayList<Integer> operations = new ArrayList<Integer>(Arrays.asList(10, 5, 0, -1, 0, -1, 0));
        ArrayList<Integer> operations = new ArrayList<Integer>(Arrays.asList(0, 266446980, 0, -1, -1, 514658509, 622550429, -1, 54485858, 134766135, 99932008, 0, 312674088, 0, -1, 0, 0, 0, -1, 787360385, 0, 1487648841, 0, -1, 0, 0, -1, 505759639, 1321636078, 518012428, 0, 1454618279, -1, 0, 955142261, -1, 0, 0, 0, 0, 1602765219, -1, 960966637, 822866358, -1, 0, 1724788732, -1, 1440634301, -1, 0, 0, 926949789, -1, 0, -1, -1, 0, 0, 0, -1, 0, -1, 0, 0, -1, -1, 1227957521, 1985203753, 81271693, 1108673592, -1, 1616852971, 0, 0, 1959976093, 1828629469, 577999668, -1, 1197289583, 0, -1, -1, -1, -1, 0, 0, 0, 1711319859, 210445507, 1210662582, -1));
        ArrayList<Integer> result = min_stack(operations);
        int a = 4;
    }

    static ArrayList<Integer> min_stack(ArrayList<Integer> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < operations.size(); i++){
            int curr_oper = operations.get(i);
            if(curr_oper == -1 && !stack.isEmpty()){
                if(minStack.peek().equals(stack.peek()))
                    minStack.pop();
                stack.pop();
            }else if (curr_oper == -1 && stack.isEmpty()){

            }
            else if(curr_oper == 0){
                if(!minStack.isEmpty())
                    result.add(minStack.peek());
                else
                    result.add(-1);
            } else{
                stack.push(curr_oper);
                if(!minStack.isEmpty() && minStack.peek() >= curr_oper)
                    minStack.push(curr_oper);
                else if(minStack.isEmpty())
                    minStack.push(curr_oper);
            }
        }

        return result;
    }

}
