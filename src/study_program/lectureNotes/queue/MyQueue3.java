package study_program.lectureNotes.queue;

import java.util.Stack;

public class MyQueue3 {
    Stack stack;
    public MyQueue3() {
        stack = new Stack();
    }

    public void push(int x) {
        if(stack.empty()){
            stack.push(x);
        }else{
            int curr_item = (int)stack.pop();
            push(x);
            stack.push(curr_item);
        }

    }

    public int pop() {
        return (int)stack.pop();
    }

    public int peek() {
        return (int)stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}
