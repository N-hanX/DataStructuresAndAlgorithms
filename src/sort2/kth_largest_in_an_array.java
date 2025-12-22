package sort2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class kth_largest_in_an_array {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(1);
        numbers.add(10);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(6);
        numbers.add(8);
        numbers.add(11);

        int k = 5;

        int result = kth_largest_in_an_array_func(numbers, k);
        int a = 5;
    }

    public static Integer kth_largest_in_an_array_func(ArrayList<Integer> numbers, Integer k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            pq.add(numbers.get(i));
        }

        for(int i = k; i < numbers.size(); i++){
            if(pq.peek() < numbers.get(i)){
                pq.poll();
                pq.add(numbers.get(i));
            }
        }

        return pq.peek();
    }
}
