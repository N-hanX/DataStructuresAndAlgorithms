package study_program.lectureNotes.stack;

public class MinStack {

    int capacity;
    int curr_size;
    int[] stackArr;

    int min_capacity;
    int min_curr_size;
    int[] minStack;

    int MIN_SIGN = 1;
    int ORIG_SIGN  = 0;

    public MinStack() {
        this.capacity = 1; // initialize
        this.curr_size = 0;
        stackArr = new int[capacity];

        this.min_capacity = 1; // initialize
        this.min_curr_size = 0;
        minStack = new int[min_capacity];
    }

    public void doubleArr(int whichStack){
        if(whichStack == ORIG_SIGN) {
            int[] currArr = new int[capacity * 2];

            for (int i = 0; i < curr_size; i++) {
                currArr[i] = stackArr[i];
            }
            stackArr = currArr;
            capacity = capacity * 2;
        }else{
            int[] currMinArr = new int[min_capacity * 2];

            for (int i = 0; i < min_curr_size; i++) {
                currMinArr[i] = minStack[i];
            }
            minStack = currMinArr;
            min_capacity = min_capacity * 2;
        }
    }

    public void shrinkArr(int whichStack){
        if(whichStack == ORIG_SIGN) {
            int[] currArr = new int[capacity / 2];

            for (int i = 0; i < curr_size; i++) {
                currArr[i] = stackArr[i];
            }
            stackArr = currArr;
            capacity = capacity / 2;
        }else{
            int[] currArr = new int[min_capacity / 2];

            for (int i = 0; i < min_curr_size; i++) {
                currArr[i] = minStack[i];
            }
            minStack = currArr;
            min_capacity = min_capacity / 2;
        }
    }

    public void push(int val) {
        if(capacity / 2 < (curr_size + 1)){
            // grow array
            doubleArr(ORIG_SIGN);
        }

        int curr_ind = curr_size;
        stackArr[curr_ind] = val;
        curr_size++;
        if(min_curr_size == 0 || getMin() >= val){
            if(min_capacity / 2 < (min_curr_size + 1)){
                // grow array
                doubleArr(MIN_SIGN);
            }
            minStack[min_curr_size] = val;
            min_curr_size++;
        }
    }

    public void pop() {
        if(capacity / 4 > (curr_size - 1)){
            shrinkArr(ORIG_SIGN);
        }
        if(min_capacity / 4 > (min_curr_size - 1)){
            shrinkArr(MIN_SIGN);
        }
        if(min_curr_size > 0 && minStack[min_curr_size - 1] == stackArr[curr_size - 1]){
            minStack[min_curr_size - 1] = 0;
            min_curr_size--;
        }
        stackArr[curr_size - 1] = 0;
        curr_size--;
    }

    public int top() {
        return stackArr[curr_size - 1];
    }

    public int getMin() {
        return minStack[min_curr_size - 1];
    }

    public static void main(String[] args) {
//      ["MinStack","push","push","push","getMin","pop","top","getMin"]
//  [[],[-2],[0],[-3],[],[],[],[]]
//
//        MinStack stack = new MinStack();
//        stack.push(-2);
//        stack.push(0);
//        stack.push(-3);
//        int a = stack.getMin();
//        stack.pop();
//        int b = stack.top();
//        int c = stack.getMin();

        // ["MinStack","push","push","push","getMin","top","pop","getMin"]
        // [[],[-2],[0],[-1],[],[],[],[]]

//        MinStack stack = new MinStack();
//        stack.push(-2);
//        stack.push(0);
//        stack.push(-1);
//        int a = stack.getMin();
//        int b = stack.top();
//        stack.pop();
//        int d = stack.getMin();;

//        ["MinStack","push","push","push","getMin","pop","getMin"]
//        [[],[0],[1],[0],[],[],[]]

        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        int a = stack.getMin();
        stack.pop();
        int b = stack.getMin();

        int t = 6;



    }

}
