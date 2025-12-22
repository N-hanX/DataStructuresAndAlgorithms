package study_program.problemSet.linkedList_stack_queue;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
//        {
//            "capacity": 2,
//                "query_type": [1, 1, 0, 1, 0, 1, 0],
//            "key": [5, 10, 5, 15, 10, 5, 5],
//            "value": [11, 22, 1, 33, 1, 55, 1]
//        }
//        int capacity = 2;
//        ArrayList<Integer> query_time = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 0, 1, 0));
//        ArrayList<Integer> key = new ArrayList<>(Arrays.asList(5, 10, 5, 15, 10, 5, 5));
//        ArrayList<Integer> value = new ArrayList<>(Arrays.asList(11, 22, 1, 33, 1, 55, 1));


        int capacity = 1;
        ArrayList<Integer> query_time = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0, 0, 1, 0, 0));
        ArrayList<Integer> key = new ArrayList<>(Arrays.asList(10, 10, 10, 20, 10, 20, 30, 20, 30));
        ArrayList<Integer> value = new ArrayList<>(Arrays.asList(1, 100, 1, 200, 1, 1, 300, 1, 1));


        ArrayList<Integer> result = implement_lru_cache(capacity, query_time, key,value);
        int a = 4;
    }

    static class ListNode{
        ListNode prev;
        ListNode next;
        int value;
        int key;

        public ListNode(int key, int value){
            this.value = value;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    static class Cache{
        int capacity;
        int size;
        ListNode head;
        ListNode tail;
        Map<Integer, ListNode> setOfKeys;

        public Cache(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.setOfKeys = new HashMap<>();
            this.head = null;
            this.tail = null;
        }
    }
    static Cache cache;

    public static void findTheNodeAndChangeToTail(int key){
        if(cache.capacity == 1){
            return;
        }

        ListNode temp_node = cache.setOfKeys.get(key);
        ListNode tail_node = cache.tail;

        if(tail_node != null && tail_node.key == key)
            return;

        ListNode the_node = temp_node;

        ListNode prev_node = the_node.prev;
        ListNode next_node = the_node.next;
        if(prev_node != null)
            prev_node.next = next_node;
        else
            cache.head = next_node;

        next_node.prev = prev_node;

        tail_node.next = the_node;
        the_node.prev = tail_node;
        the_node.next = null;

        cache.tail = the_node;
    }

    public static int get(int key){
        if(cache.setOfKeys.containsKey(key)){
            findTheNodeAndChangeToTail(key);
            return cache.setOfKeys.get(key).value;
        }else{
            return -1;
        }
    }

    public static void set(int key, int value){
        if(cache.setOfKeys.containsKey(key)){
            ListNode node = cache.setOfKeys.get(key);
            node.value = value;
            findTheNodeAndChangeToTail(key);
        }else{
            ListNode newNode = new ListNode(key, value);
            cache.setOfKeys.put(key, newNode);
            cache.size++;
            if(cache.size > cache.capacity){
                ListNode the_head = cache.head;
                int the_head_key = the_head.key;
                ListNode next_head = the_head.next;
                if(next_head != null)
                    next_head.prev = null;
                the_head = null;
                cache.head = next_head;
                cache.size = cache.capacity;
                cache.setOfKeys.remove(the_head_key);
            }
            if(cache.head == null) {
                cache.head = newNode;
            }

            ListNode the_tail = cache.tail;
            if(the_tail != null) {
                the_tail.next = newNode;
                newNode.prev = the_tail;
            }
            cache.tail = newNode;
            cache.tail.next = null;
        }
    }

    public static ArrayList<Integer> implement_lru_cache(Integer capacity,
                    ArrayList<Integer> query_type, ArrayList<Integer> key, ArrayList<Integer> value) {
        cache = new Cache(capacity);
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < query_type.size(); i++){
            int curr_query = query_type.get(i);
            int curr_key = key.get(i);
            int curr_val = value.get(i);

            if(curr_query == 1)
                set(curr_key, curr_val);
            else
                result.add(get(curr_key));
        }

        return result;
    }
}
