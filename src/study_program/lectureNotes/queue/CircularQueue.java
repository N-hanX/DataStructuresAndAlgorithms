package study_program.lectureNotes.queue;

public class CircularQueue {
    int capacity;
    int curr_size;
    ListNode head;
    ListNode tail;

    public CircularQueue(int k){
        this.capacity = k;
        this.curr_size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean enQueue(Integer value){
        if(curr_size < capacity){
            if(curr_size == 0){
                head = new ListNode(value);
                tail = head;
            }else{
                ListNode node = new ListNode(value);
                if(curr_size + 1 == capacity){
                    tail.next = node;
                    node.next = head;
                    tail = node;
                }else {
                    tail.next = node;
                    tail = node;
                }
            }
            curr_size++;
            return  true;
        }else{
            return false;
        }
    }

    public Integer Rear(){
        if(tail != null)
            return tail.val;
        return -1;
    }

    public Integer Front(){
        if(head != null)
            return head.val;
        return -1;
    }

    public boolean isFull(){
        if(this.capacity == this.curr_size)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(this.curr_size == 0)
            return true;
        return false;
    }

    public boolean deQueue(){
        if(isEmpty())
            return false;

        if(head == tail && head != null){
            head = null;
            tail = null;
            curr_size--;
            return true;
        }

        ListNode next_node = head.next;
        head = next_node;
        if(isFull())
            tail.next = null;

        if(head != null){
            curr_size--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        CircularQueue myCircularQueue = new CircularQueue(3);
//        boolean result1 = myCircularQueue.enqueue(1);
//        boolean result2 = myCircularQueue.enqueue(2);
//        boolean result3 = myCircularQueue.enqueue(3);
//        boolean result4 = myCircularQueue.enqueue(4);
//
//        int result5 = myCircularQueue.rear();
//        boolean result6 = myCircularQueue.isFull();
//        boolean result7 = myCircularQueue.dequeue();
//        boolean result8 = myCircularQueue.enqueue(4);
//        int result9 = myCircularQueue.rear();

//["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
//        [[6],[6],[],[],[],[5],[],[],[],[],[],[]]
        CircularQueue myCircularQueue = new CircularQueue(6);
        boolean result1 = myCircularQueue.enQueue(6);
        int result2 = myCircularQueue.Rear();
        int result3 = myCircularQueue.Rear();
        boolean result4 = myCircularQueue.deQueue();
        boolean result5 = myCircularQueue.enQueue(5);
        int result6 = myCircularQueue.Rear();

        boolean result7 = myCircularQueue.deQueue();
        int result8 = myCircularQueue.Front();
        boolean result9 = myCircularQueue.deQueue();
        boolean result10 = myCircularQueue.deQueue();
        boolean result11 = myCircularQueue.deQueue();

        int a = 5;
    }
}
