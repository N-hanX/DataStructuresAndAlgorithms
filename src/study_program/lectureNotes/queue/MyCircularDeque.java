package study_program.lectureNotes.queue;

class MyCircularDeque {
   int capacity;
   int curr_size;
   int head_ind;
   int tail_ind;
   int[] deque_arr;

   public MyCircularDeque(int k) {
      head_ind = -1;
      tail_ind = -1;
      deque_arr = new int[k];
      capacity = k;
      curr_size = 0;
      for(int i = 0; i < k; i++)
         deque_arr[i] = -1;
   }

   public boolean insertFront(int value) {
      if(isFull())
         return false;

      if(head_ind > 0){
         head_ind = head_ind - 1;
      }else{
         head_ind = capacity - 1;
      }
      if(curr_size == 0)
         tail_ind = head_ind;

      deque_arr[head_ind] = value;
      curr_size++;
      return  true;
   }

   public boolean insertLast(int value) {
      if(isFull())
         return false;

      if(tail_ind == capacity - 1){
         tail_ind = 0;
      }else if(tail_ind < capacity - 1){
         tail_ind++;
      }
      deque_arr[tail_ind] = value;
      if(curr_size == 0)
         head_ind = tail_ind;

      curr_size++;
      return true;
   }

   public boolean deleteFront() {
      if(isEmpty())
         return false;

      deque_arr[head_ind] = -1;
      if(head_ind == capacity - 1)
         head_ind = 0;
      else
         head_ind++;

      curr_size--;

      if(curr_size == 0){
         tail_ind = -1;
         head_ind = -1;
      }

      return true;
   }

   public boolean deleteLast() {
      if(isEmpty())
         return false;

      deque_arr[tail_ind] = -1;
      if(tail_ind == 0)
         tail_ind = capacity - 1;
      else
         tail_ind--;

      curr_size--;

      if(curr_size == 0){
         tail_ind = -1;
         head_ind = -1;
      }
      return true;
   }

   public int getFront() {
      if(isEmpty())
         return -1;
      return deque_arr[head_ind];
   }

   public int getRear() {
      if(isEmpty())
         return -1;
      return deque_arr[tail_ind];
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
//      MyCircularDeque myCircularDeque = new MyCircularDeque(5);
//      myCircularDeque.insertFront(7);
//      myCircularDeque.insertLast(0);
//      myCircularDeque.getFront();
//      myCircularDeque.insertLast(3);
//      myCircularDeque.getFront();
//      myCircularDeque.insertLast(9);
//      myCircularDeque.getRear();
//      myCircularDeque.getFront();
//      myCircularDeque.getFront();
//      myCircularDeque.deleteLast();
//      myCircularDeque.getRear();
      int a = 5;

   //      ***********************  TEST - 2 ***********************
//["MyCircularDeque","insertFront","getRear","deleteLast","getRear","insertFront","insertFront","insertFront",
// "insertFront","isFull","insertFront","isFull","getRear","deleteLast","getFront","getFront","insertLast","deleteFront","getFront","insertLast","getRear","insertLast","getRear","getFront","getFront","getFront","getRear","getRear","insertFront","getFront","getFront","getFront","getFront","deleteFront","insertFront","getFront","deleteLast","insertLast","insertLast","getRear","getRear","getRear","isEmpty","insertFront","deleteLast","getFront","deleteLast","getRear","getFront","isFull","isFull","deleteFront","getFront","deleteLast","getRear","insertFront","getFront","insertFront","insertFront","getRear","isFull","getFront","getFront","insertFront","insertLast","getRear","getRear","deleteLast","insertFront","getRear","insertLast","getFront","getFront","getFront","getRear","insertFront","isEmpty","getFront","getFront","insertFront","deleteFront","insertFront","deleteLast","getFront","getRear","getFront","insertFront","getFront","deleteFront","insertFront","isEmpty","getRear","getRear","getRear","getRear","deleteFront","getRear","isEmpty","deleteFront","insertFront","insertLast","deleteLast"]
//      [[77],[89],[],[],[],[19],[23],[23],[82],[],[45],[],[],[],[],[],[74],[],
      MyCircularDeque myCircularDeque1 = new MyCircularDeque(25);
      myCircularDeque1.insertFront(89);
      myCircularDeque1.getRear();
      myCircularDeque1.deleteLast();
      myCircularDeque1.getRear();
      myCircularDeque1.insertFront(19);
      myCircularDeque1.insertFront(23);
      myCircularDeque1.insertFront(23);
      myCircularDeque1.insertFront(82);
      myCircularDeque1.isFull();
      myCircularDeque1.insertFront(45);
      myCircularDeque1.isFull();
      myCircularDeque1.getRear();
      myCircularDeque1.deleteLast();
      myCircularDeque1.getFront();
      myCircularDeque1.insertLast(74);
      myCircularDeque1.deleteFront();

      int m = 5;

   }
}

   /**
   * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
