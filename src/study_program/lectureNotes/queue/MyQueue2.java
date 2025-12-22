package study_program.lectureNotes.queue;

import java.util.Stack;

class MyQueue2 {
    Stack stack1;
    Stack stack2;

    public MyQueue2() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                int val = (int)stack1.pop();
                stack2.push(val);
            }
        }
        return (int)stack2.pop();
    }

    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty()){
                int val = (int)stack1.pop();
                stack2.push(val);
            }
        }
        return (int)stack2.peek();
    }

    public boolean empty() {
        if(stack2.empty()){
            while(!stack1.empty()){
                int val = (int)stack1.pop();
                stack2.push(val);
            }
        }
        return stack2.empty();
    }
}
