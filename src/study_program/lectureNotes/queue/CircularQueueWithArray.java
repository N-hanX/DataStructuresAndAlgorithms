package study_program.lectureNotes.queue;

public class CircularQueueWithArray {
    int curr_size;
    int[] circularQueue;
    int total_capacity;
    int head_ind;
    int tail_ind;

    public CircularQueueWithArray(int k) {
        curr_size = 0;
        total_capacity = k;
        head_ind = -1; // -1 means array is empty
        tail_ind = -1; // -1 means array is empty
        circularQueue = new int[total_capacity];
        for(int i = 0; i < total_capacity; i++){
            circularQueue[i] = -1;
        }
    }


    public boolean enQueue(int value) {
        if(isFull())
            return false;

        if(head_ind == -1)
            head_ind = 0;

        if(tail_ind == -1)
            tail_ind = 0;
        else
            tail_ind = (tail_ind + 1) % total_capacity;

        circularQueue[tail_ind] = value;
        curr_size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        // fill the operator

        curr_size--;
        circularQueue[head_ind] = -1;

        if(curr_size > 0)
            head_ind = (head_ind + 1) % total_capacity;
        else {
            head_ind = -1;
            tail_ind = -1;
        }

        if(curr_size == 1 || curr_size == 0)
            tail_ind = head_ind;

        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;

        return circularQueue[head_ind];
    }

    public int Rear() {
        if(isEmpty())
            return -1;

        return circularQueue[tail_ind];
    }

    public boolean isEmpty() {
        if(curr_size == 0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(curr_size == total_capacity)
            return true;
        return false;
    }

    public static void main(String[] args) {
//        ***************** TEST : 1 *****************
//["MyCircularQueue","enQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue","enQueue","deQueue", "Front"]
// [[2],[1],[2],[],[3],[],[3],[],[3],[],[]]
//        CircularQueueWithArray myCircularQueue = new CircularQueueWithArray(2);
//        boolean result1 = myCircularQueue.enQueue(1);
//        boolean result2 = myCircularQueue.enQueue(2);
//        boolean result3 = myCircularQueue.deQueue();
//        boolean result4 = myCircularQueue.enQueue(3);
//        boolean result5 = myCircularQueue.deQueue();
//
//        boolean result6 = myCircularQueue.enQueue(3);
//        boolean result7 = myCircularQueue.deQueue();
//        boolean result8 = myCircularQueue.enQueue(3);
//        boolean result9 = myCircularQueue.deQueue();
//        int result10 = myCircularQueue.Front();

        //        ***************** TEST : 2 *****************
//["MyCircularQueue","enQueue","Front","enQueue","Rear","enQueue","enQueue","Rear","deQueue","Front","deQueue","Front"]
//        [[7],[0],[],[4],[],[6],[3],[],[],[],[],[]]
//
//        CircularQueueWithArray myCircularQueue = new CircularQueueWithArray(7);
//        boolean result1 = myCircularQueue.enQueue(0);
//        int result2 = myCircularQueue.Front();
//        Boolean result3 = myCircularQueue.enQueue(4);
//        int result4 = myCircularQueue.Rear();
//        Boolean result5 = myCircularQueue.enQueue(6);
//        Boolean result6 = myCircularQueue.enQueue(3);
//        int result7 = myCircularQueue.Rear();
//        Boolean result8 = myCircularQueue.deQueue();
//        int result9 = myCircularQueue.Front();
//        Boolean result10 = myCircularQueue.deQueue();
//        int result11 = myCircularQueue.Front();

        //        ***************** TEST : 3 *****************
//["MyCircularQueue","enQueue","deQueue","enQueue","enQueue","deQueue","isFull","isFull","Front","deQueue","enQueue","Front","enQueue","enQueue","Rear","Rear","deQueue","enQueue","enQueue","Rear","Rear","Front","Rear","Rear","deQueue","enQueue","Rear","deQueue","Rear","Rear","Front","Front","enQueue","enQueue","Front","enQueue","enQueue","enQueue","Front","isEmpty","enQueue","Rear","enQueue","Front","enQueue","enQueue","Front","enQueue","deQueue","deQueue","enQueue","deQueue","Front","enQueue","Rear","isEmpty","Front","enQueue","Front","deQueue","enQueue","enQueue","deQueue","deQueue","Front","Front","deQueue","isEmpty","enQueue","Rear","Front","enQueue","isEmpty","Front","Front","enQueue","enQueue","enQueue","Rear","Front","Front","enQueue","isEmpty","deQueue","enQueue","enQueue","Rear","deQueue","Rear","Front","enQueue","deQueue","Rear","Front","Rear","deQueue","Rear","Rear","enQueue","enQueue","Rear","enQueue"]
//        [[81],[69],[],[92],[12],[],[],[],[],[],[28],[],[13],[45],[],[],[],[24],[27],[],[],[],[],[],[],[88],[],[],[],[],[],[],[53],[39],[],[28],[66],[17],[],[],[47],[],[87],[],[92],[94],[],[59],[],[],[99],[],[],[84],[],[],[],[52],[],[],[86],[30],[],[],[],[],[],[],[45],[],[],[83],[],[],[],[22],[77],[23],[],[],[],[14],[],[],[90],[57],[],[],[],[],[34],[],[],[],[],[],[],[],[49],[59],[],[71]]
        CircularQueueWithArray myCircularQueue = new CircularQueueWithArray(81);
        Boolean result1 = myCircularQueue.enQueue(69);
        Boolean result2 = myCircularQueue.deQueue();
        Boolean result3 = myCircularQueue.enQueue(92);
        Boolean result4 = myCircularQueue.enQueue(12);
        Boolean result5 = myCircularQueue.deQueue();
        Boolean result6 = myCircularQueue.isFull();
        Boolean result7 = myCircularQueue.isFull();
        int result8 = myCircularQueue.Front();
        Boolean result9 = myCircularQueue.deQueue();
        Boolean result10 = myCircularQueue.enQueue(28);
        int result11 = myCircularQueue.Front();
        Boolean result12 = myCircularQueue.enQueue(13);
        Boolean result13 = myCircularQueue.enQueue(45);
        int result14 = myCircularQueue.Rear();


        int a = 5;
    }
}
