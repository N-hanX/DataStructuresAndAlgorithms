package study_program.lectureNotes.queue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Integer peek_value;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        peek_value = null;
    }

    public void push(int x) {
        if(stack1.isEmpty())
            peek_value = x;
        stack1.push(x);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            int the_currVal = stack1.pop();
            stack2.push(the_currVal);
        }

        int the_val = stack2.pop();
        if(!stack2.isEmpty())
            peek_value = stack2.peek();
        else
            peek_value = null;

        while(!stack2.isEmpty()){
            int the_currVal = stack2.pop();
            stack1.push(the_currVal);
        }
        return the_val;
    }

    public int peek() {
        return peek_value;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
