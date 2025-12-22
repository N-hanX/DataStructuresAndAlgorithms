package study_program.problemSet.adhoc;

import java.util.*;

public class DesignAndImplementLRUCache {
    public static void main(String[] args) {
//        {
//            "capacity": 2,
//                "query_type": [1, 1, 0, 1, 0, 1, 0],
//            "key": [5, 10, 5, 15, 10, 5, 5],
//            "value": [11, 22, 1, 33, 1, 55, 1]
//        }

        int capacity = 2;
        ArrayList<Integer> query_type = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 0, 1, 0));
        ArrayList<Integer> key = new ArrayList<>(Arrays.asList(5, 10, 5, 15, 10, 5, 5));
        ArrayList<Integer> value = new ArrayList<>(Arrays.asList(11, 22, 1, 33, 1, 55, 1));

        ArrayList<Integer> result = implement_lru_cache(capacity, query_type, key, value);

        int a = 4;
    }

    Stack<Key_Value_Storage> least_recently_used = new Stack<>();
    Map<Integer, Integer> all_the_cache = new HashMap();
    Queue<Key_Value_Storage> list_by_latest_used = new PriorityQueue<>();

    class Key_Value_Storage{
        int key;
        int value;

        public Key_Value_Storage(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key_Value_Storage that = (Key_Value_Storage) o;
            return key == that.key && value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    static ArrayList<Integer> implement_lru_cache(Integer capacity, ArrayList<Integer> query_type, ArrayList<Integer> key, ArrayList<Integer> value) {
        int count_ind = 0;
        int num_of_total_query = query_type.size();

        ArrayList<Integer> result = new ArrayList<>();

        while(count_ind < num_of_total_query){
            int current_query = query_type.get(count_ind);

            // SET the key
            if(current_query == 1){
                //

            }else if(current_query == 0){ // get the key if available and put it into result
                // find the key
            }

            // if total capacity exceed the total capacity delete the last one


            count_ind++;
        }

        return result;
    }

    static void set_the_number(int the_key, int the_value, int capacity, Stack<Key_Value_Storage> least_recently_used,
                               Set<Key_Value_Storage> all_the_cache, Queue<Key_Value_Storage> list_by_latest_use,
                               Set<Integer> keys){

        if(!keys.contains(the_key)){

            // check the size of cache
            if(all_the_cache.size() == capacity){
                // get the latest number and remove it and add new one and add to the stack
                Key_Value_Storage the_latest = list_by_latest_use.poll();
                all_the_cache.remove(the_latest);

                // find the value in stack



            }
        }

    }
}











