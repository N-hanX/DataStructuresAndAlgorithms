package study_program.lectureNotes.queue;

public class ResizeCircularQueue {
    int capacity;
    int curr_size;
    int head_ind;
    int tail_ind;
    int[] queue_arr;

    public ResizeCircularQueue(int size){
        head_ind = -1;
        tail_ind = -1;
        queue_arr = new int[size];
        curr_size = 0;
        capacity = size;
        for(int i = 0; i < capacity; i++){
            queue_arr[i] = -1;
        }
    }

    public void resize(int value){
        int[] new_arr = new int[capacity * 2];
        if(tail_ind < head_ind){
            int counter = 0;
            int tail_counter_ind = head_ind;
            while(tail_counter_ind < capacity){
                new_arr[counter] = queue_arr[tail_counter_ind];
                tail_counter_ind++;
                counter++;
            }
            int temp_starter_ind = 0;
            while(temp_starter_ind <= tail_ind){
                new_arr[counter] = queue_arr[temp_starter_ind];
                counter++;
                temp_starter_ind++;
            }
        }else{
            int counter = 0;
            while(head_ind <= tail_ind){
                new_arr[counter] = queue_arr[head_ind];
                head_ind++;
                counter++;
            }
        }
        queue_arr = new_arr;
        capacity = capacity * 2;
        head_ind = 0;
        queue_arr[curr_size] = value;
        tail_ind = curr_size;
        curr_size++;
    }

    public Boolean enQueue(int value) {
        if(isFull()){
            //2 katina cikar
            resize(value);
        }else{
            // onceki algoritmayi tekrar yazalim. BAkmadan
            if(curr_size == 0){
                tail_ind = 0;
                head_ind = 0;
            }else{
                tail_ind = (tail_ind + 1) % capacity;
            }
            queue_arr[tail_ind] = value;
            curr_size++;
        }
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;

        queue_arr[head_ind] = -1;
        head_ind = (head_ind + 1) % capacity;
        curr_size--;
        if(curr_size == 0){
            head_ind = -1;
            tail_ind = -1;
        }

        return true;
    }

    public Integer Rear() {
        if(isEmpty())
            return -1;
        return queue_arr[tail_ind];
    }

    public Integer Front(){
        if(isEmpty())
            return -1;
        return queue_arr[head_ind];
    }

    public boolean isEmpty() {
        if(curr_size == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(capacity == curr_size)
            return true;
        return false;
    }

    public static void main(String[] args) {
        ResizeCircularQueue myCircularQueue = new ResizeCircularQueue(3);
        Boolean result1 = myCircularQueue.enQueue(69);
        Boolean result2 = myCircularQueue.deQueue();
        Boolean result3 = myCircularQueue.enQueue(92);
        Boolean result4 = myCircularQueue.enQueue(12);
        Boolean result4_1 = myCircularQueue.enQueue(15);
        Boolean result5 = myCircularQueue.deQueue();
        Boolean result6 = myCircularQueue.isFull();
        Boolean result7 = myCircularQueue.isFull();
        int result8 = myCircularQueue.Front();
        Boolean result9 = myCircularQueue.deQueue();
        Boolean result10 = myCircularQueue.enQueue(28);
        int result11 = myCircularQueue.Front();
        Boolean result12 = myCircularQueue.enQueue(13);
        Boolean result13 = myCircularQueue.enQueue(45);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);

        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        myCircularQueue.deQueue();

        myCircularQueue.enQueue(44);
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(66);

        myCircularQueue.enQueue(76);


        int result14 = myCircularQueue.Rear();
        int a = 5;
    }
}
