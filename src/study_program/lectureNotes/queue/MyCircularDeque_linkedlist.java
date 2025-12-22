package study_program.lectureNotes.queue;

public class MyCircularDeque_linkedlist {
    class ListDoubleNode{
        int value;
        int key;
        ListDoubleNode next;
        ListDoubleNode prev;

        public ListDoubleNode(int value){
            this.value = value;
        }
        public ListDoubleNode(int value, int key){
            this.value = value;
            this.key = key;
        }
    }

    ListDoubleNode head;
    ListDoubleNode tail;
    int curr_size;
    int capacity;


    public MyCircularDeque_linkedlist(int k) {
        this.curr_size = 0;
        this.capacity = k;
        this.head = null;
        this.tail = null;
    }

    public boolean insertFront(int value) {
        if(isFull())
            return false;

        if(isEmpty()){
            head = new ListDoubleNode(value);
            tail = head;
        }else{
            ListDoubleNode prev_head = head;
            ListDoubleNode new_head = new ListDoubleNode(value);
            new_head.next = prev_head;
            prev_head.prev = new_head;
            head = new_head;
        }
        curr_size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;

        if(isEmpty()){
            head = new ListDoubleNode(value);
            tail = head;
        }else{
            ListDoubleNode prev_tail = tail;
            ListDoubleNode new_tail = new ListDoubleNode(value);
            prev_tail.next = new_tail;
            tail = new_tail;
            new_tail.prev = prev_tail;
        }
        curr_size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty())
            return false;
        if(curr_size > 1) {
            ListDoubleNode next_node = head.next;
            next_node.prev = null;
            head = next_node;
        }else{
            head = null;
            tail = null;
        }
        curr_size--;
        if(curr_size == 1)
            head = tail;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;
        if(curr_size > 1) {
            ListDoubleNode prev_node = tail.prev;
            prev_node.next = null;
            tail = prev_node;
        }else{
            tail = null;
            head = null;
        }
        curr_size--;
        if(curr_size == 1)
            head = tail;
        return true;
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return head.value;
    }

    public int getRear() {
        if(isEmpty())
            return -1;
        return tail.value;
    }

    public boolean isEmpty() {
        if(curr_size == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(curr_size == capacity)
            return true;
        return false;
    }

    public static void main(String[] args) {
        //      ***********************  TEST - 1 ***********************
//      ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront","insertFront","getRear",
//      "getFront","getFront","deleteLast","getRear"]
//      [[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
//        MyCircularDeque_linkedlist myCircularDeque = new MyCircularDeque_linkedlist(5);
//        myCircularDeque.insertFront(7);
//        myCircularDeque.insertLast(0);
//        myCircularDeque.getFront();
//        myCircularDeque.insertLast(3);
//        myCircularDeque.getFront();
//        myCircularDeque.insertLast(9);
//        myCircularDeque.getRear();
//        myCircularDeque.getFront();
//        myCircularDeque.getFront();
//        myCircularDeque.deleteLast();
//        myCircularDeque.getRear();


        //      ***********************  TEST - 2 ***********************

// ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
//[[3],[1],[2],[3],[4],[],[],[],[4],[]]

//        MyCircularDeque_linkedlist myCircularDeque = new MyCircularDeque_linkedlist(3);
//        myCircularDeque.insertLast(1);
//        myCircularDeque.insertFront(2);
//        myCircularDeque.insertFront(3);
//        int a1 = myCircularDeque.getRear();
//        boolean a2 = myCircularDeque.isFull();
//        myCircularDeque.deleteLast();
//        myCircularDeque.insertFront(4);
//        myCircularDeque.getFront();


        //      ***********************  TEST - 3 ***********************
//["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear",
// "insertLast","insertFront","deleteLast","insertLast","isEmpty"]
//[[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
        MyCircularDeque_linkedlist myCircularDeque = new MyCircularDeque_linkedlist(8);
        Boolean result0 = myCircularDeque.insertFront(5);
        int result1 = myCircularDeque.getFront();
        Boolean result2 = myCircularDeque.isEmpty();
        Boolean result3 = myCircularDeque.deleteFront();
        Boolean result4 = myCircularDeque.insertLast(3);
        int result5 = myCircularDeque.getRear();
        Boolean result6 = myCircularDeque.insertLast(7);
        Boolean result7 = myCircularDeque.insertFront(7);
        Boolean result8 = myCircularDeque.deleteLast();
        Boolean result9 = myCircularDeque.insertLast(4);
        Boolean result10 = myCircularDeque.isEmpty();
        int a = 5;
    }
}
