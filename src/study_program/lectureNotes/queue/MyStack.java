package study_program.lectureNotes.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /// 1, 2, 3, 4, 5 sirasiyla/ push deyince 5 gelsin queue'da
    // 5,4,3,2,1

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if(!queue1.isEmpty())
            queue1.add(x);
        else
            queue2.add(x);
    }


    public int pop() {
        int the_last_item = -1;
        if(!queue1.isEmpty()){
            while(!queue1.isEmpty()){
                the_last_item = queue1.poll();
                if(!queue1.isEmpty())
                    queue2.add(the_last_item);
            }
        }else{
            while(!queue2.isEmpty()){
                the_last_item = queue2.poll();
                if(!queue2.isEmpty())
                    queue1.add(the_last_item);
            }
        }
        return the_last_item;
    }

    public int top() {
        int the_last_item = -1;
        if(!queue1.isEmpty()){
            while(!queue1.isEmpty()){
                the_last_item = queue1.poll();
                queue2.add(the_last_item);
            }
        }else{
            while(!queue2.isEmpty()){
                the_last_item = queue2.poll();
                queue1.add(the_last_item);
            }
        }
        return the_last_item;

    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
//        MyStack stack = new MyStack();
//        stack.push(1);
//        stack.push(2);
//        int a = stack.top();
//        stack.pop();
//        boolean b = stack.empty();
//        int zzzz = 4;

        // ["MyStack","push","push","push","push","push","top","pop","top"]
        // [[],[1],[2],[3],[4],[2],[],[],[]]
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        int a = stack.top();
        int b = stack.pop();
        int c = stack.top();
        int aaa = 5;
    }
}
