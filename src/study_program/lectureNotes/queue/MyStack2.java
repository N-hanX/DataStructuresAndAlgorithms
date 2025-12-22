package study_program.lectureNotes.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();

        int get_the_nth_element = size - 1;
        int counter = 0;

        while(counter <= get_the_nth_element){
            int the_element = queue.poll();
            if(counter == get_the_nth_element)
                return the_element;
            else
                queue.add(the_element);
            counter++;
        }

        return -1;
    }

    public int top() {
        int size = queue.size();

        int get_the_nth_element = size - 1;
        int counter = 0;

        while(counter <= get_the_nth_element){
            int the_element = queue.poll();
            queue.add(the_element);
            if(counter == get_the_nth_element)
                return the_element;
            counter++;
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
