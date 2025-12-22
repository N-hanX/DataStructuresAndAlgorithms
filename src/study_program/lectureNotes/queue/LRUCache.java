package study_program.lectureNotes.queue;

import java.util.HashMap;
import java.util.Map;

// PUT operastonu icin eger kapasitede bos yer varsa yani dolu degilse
// eger kapasite doluysa
// eger anahtar zaten cacheMap'de varsa onu son indexe koyacagiz. ve o index ile son index arasindaki butun ele
// manlari sola itekleyecegiz. Bu islem cok zaman alacagi icin aslinda bastan deque kullanmak daha dogru bir
// tercih olurdu.

// eger anahtar zaten cacheMap'de degilse onu array'deki butun elemanlari sola atmak

public class LRUCache {
    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> hmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.hmap = new HashMap<>();
    }

    public int get(int key) {
        if(!hmap.containsKey(key))
            return -1;
        else{
            Node node = hmap.get(key);
            int val = node.value;
            // now extract and put this node at the end of deque
            extract_and_append(node);
            return val;
        }
    }

    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            Node node = hmap.get(key);
            node.value = value;
            extract_and_append(node);
            return;
        }

        Node node = new Node(key, value);
        hmap.put(key, node);
        node.prev = tail;

        if(tail != null){
            tail.next = node;
            tail = node;
        }else{
            head = node;
            tail = node;
        }
        this.size++;

        if(this.size > this.capacity){
            Node nextHead = head.next;
            nextHead.prev = null;
            head.next = null;
            hmap.remove(head.key);
            head = nextHead;
            size = capacity;
        }
    }

    public void extract_and_append(Node node){
        // yani zaten taildeki node bu node ise bisey yapma
        // yada cache'de sadece bu node var ise bisey yapma
        if(this.size == 1 || this.tail == node){
            return;
        }
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if(prevNode != null)
            prevNode.next = nextNode;
        else
            this.head = nextNode;

        if(nextNode != null){ // prevNode ile nextNode'u birlestir
            nextNode.prev = null;
        }else{//demekki taile denk geldik
            tail = prevNode;
        }
        node.prev = tail;
        tail.next = node;
        node.next = null;
        tail = node;


    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int result1 = cache.get(1);
        cache.put(3, 3);
        int result2 = cache.get(2);
        cache.put(4, 4);
        int result3 = cache.get(1);
        cache.get(3);
        cache.get(4);

        // ******Test2******
//        ["LRUCache","put","get"]
//        [[1],[2,1],[2]]

//        LRUCache cache = new LRUCache(1);
//        cache.put(2, 1);
//        int result1 = cache.get(2);

        // **** test 3 *****
        //["LRUCache","put","get","put","get","get"]
        //[[1],[2,1],[2],[3,2],[2],[3]]
//        LRUCache cache = new LRUCache(1);
//        cache.put(2,1);
//        cache.get(2);
//        cache.put(3,2);
//        cache.get(2);
//        cache.get(3);

        int a = 4;
    }
}
