package sort2;

import java.util.List;
import java.util.PriorityQueue;

public class OnlineMedian {
    PriorityQueue<Integer> max_heap;                             // To store the smaller half of the input numbers.
    PriorityQueue<Integer> min_heap;  // To store the larger half of the input numbers.

    public void add_new_element(int num) {
        // Balancing heaps to make sure
        // - smaller half of input numbers are always in the max heap
        // - larger half of input numbers are always in the min heap
        max_heap.add(num);
        min_heap.add(max_heap.poll());
        max_heap.poll();

        // Maintain size property.
        // 1. max_heap.size() = min_heap.size(), when number of elements is even
        // 2. max_heap.size() = min_heap.size() + 1, when number of elements is odd
        if (min_heap.size() > max_heap.size()) {
            max_heap.add(min_heap.poll());
            min_heap.poll();
        }
    }

    public int get_current_stream_median() {
        // If number of elements in the stream is even.
        if (max_heap.size() == min_heap.size())
            return (max_heap.peek() + min_heap.peek()) / 2;

        // If number of elements in the stream is odd.
        return max_heap.peek();
    }

    public static List<Integer> online_median(List<Integer> stream){
        List<Integer> result;

        for(int i = 0; i < stream.size(); i++){
            
        }
        return null;
    }

}
