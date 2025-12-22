package study_program.problemSet.linkedList_stack_queue;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);

        node1.random = node3;
        node3.random = node4;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LinkedListNode clone = clone_linked_list(node1);

        int a = 4;
    }

    static LinkedListNode clone_linked_list(LinkedListNode head) {
        LinkedListNode temp = head;
        LinkedListNode clone_head = null;
        Map<Integer, LinkedListNode> new_clone_nodes = new HashMap<>();
        LinkedListNode new_node = null;

        LinkedListNode next_new_node = null;

        while(temp != null){
            int val = temp.value;
            Integer random_val = null;

            if(temp.random != null)
                random_val = temp.random.value;

            if(new_node == null && !new_clone_nodes.containsKey(val))
                new_node = new LinkedListNode(val);

            if(temp.next != null ) {
                if (!new_clone_nodes.containsKey(val + 1))
                    next_new_node = new LinkedListNode(val + 1);
                else
                    next_new_node = new_clone_nodes.get(val + 1);

                new_clone_nodes.put(val + 1, next_new_node);
                new_node.next = next_new_node;
            }

            if(random_val != null && new_clone_nodes.containsKey(random_val)){
                new_node.random = new_clone_nodes.get(random_val);
            }else if (random_val != null && !new_clone_nodes.containsKey(random_val)) {
                LinkedListNode random_key = new LinkedListNode(random_val);
                new_clone_nodes.put(random_val, random_key);
                new_node.random = random_key;
            }

            if(clone_head == null)
                clone_head = new_node;

            new_node = next_new_node;

            temp = temp.next;
        }

        return clone_head;
    }

    static class LinkedListNode {
        public Integer value;
        public LinkedListNode next;
        public LinkedListNode random;

        LinkedListNode(Integer node_data) {
            this.value = node_data;
            this.next = null;
            this.random = null;
        }
    }
}
