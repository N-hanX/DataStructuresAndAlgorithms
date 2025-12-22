package study_program.lectureNotes.queue;

public class MyQueue_v2 {
    MyCircularDeque_linkedlist myDeque;
    MyCircularDeque_linkedlist myMaxQueue;

    public MyQueue_v2(){
        int size = 1000;
        myDeque = new MyCircularDeque_linkedlist(size);
        myMaxQueue = new MyCircularDeque_linkedlist(size);
        // max: leftPart min, right Part is max;
    }

    public void dequeue(){
        int item = myDeque.getFront();
        int curr_max = myMaxQueue.getFront();
        myDeque.deleteFront();
        if(item == curr_max)
            myMaxQueue.deleteFront();
    }

    public void enqueue(int val){
        myDeque.insertLast(val);

        // update max
        while(!myMaxQueue.isEmpty() && myMaxQueue.getRear() < val){
            myMaxQueue.deleteFront();
        }
        myMaxQueue.insertLast(val);
    }

    public int max(){
        return myMaxQueue.getFront();
    }

    public static void main(String[] args) {
        MyQueue_v2 myQueue_v2 = new MyQueue_v2();
        myQueue_v2.enqueue(1);
        myQueue_v2.enqueue(2);
        myQueue_v2.enqueue(3);
        myQueue_v2.enqueue(5);
        myQueue_v2.dequeue();
        myQueue_v2.dequeue();
        myQueue_v2.dequeue();
        myQueue_v2.enqueue(4);
        myQueue_v2.enqueue(7);
        myQueue_v2.dequeue();
        myQueue_v2.enqueue(2);
        myQueue_v2.enqueue(9);
        myQueue_v2.dequeue();
        myQueue_v2.dequeue();



    }
}
