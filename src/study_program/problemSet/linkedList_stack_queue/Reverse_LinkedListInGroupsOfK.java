package study_program.problemSet.linkedList_stack_queue;

public class Reverse_LinkedListInGroupsOfK {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node7 = new LinkedListNode(7);
        LinkedListNode node8 = new LinkedListNode(8);
        LinkedListNode node9 = new LinkedListNode(9);
        LinkedListNode node10 = new LinkedListNode(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        LinkedListNode result = reverse_linked_list_in_groups_of_k(node1, 3);

        int a = 5;

    }

    static LinkedListNode reverse_linked_list_in_groups_of_k(LinkedListNode head, Integer k) {
        if(head == null)
            return null;

        LinkedListNode currentNode = head;
        LinkedListNode new_head = null;
        LinkedListNode prev = null;
        LinkedListNode last_element_of_curr_cluster = null;

        while(currentNode != null){
            NodeClass arranged_cluster_features = reverse_curr_group(currentNode, k);
            if(new_head == null){
                new_head = arranged_cluster_features.currStartNode;
            }

            if(prev != null){
                prev.next = arranged_cluster_features.currStartNode;
            }

            // 3,2,1 -> en son eleman 1'e eklemek lazim
            // 1, 2, 3, 4, 5, 6
            // 3, 2, 1, 6, 5, 4
            prev = currentNode;
            currentNode = arranged_cluster_features.newStartNode;
            int a = 5;
        }

        return new_head;
    }

    static NodeClass reverse_curr_group(LinkedListNode curr_start, Integer k){
        int count = 0;

        LinkedListNode prev = null;
        LinkedListNode curr_node = curr_start;
        LinkedListNode next_node = null;

        // 1, 2, 3
        // 3, 2, 1

        while(count < k && curr_node != null){
            next_node = curr_node.next;
            curr_node.next = prev;
            prev = curr_node;
            curr_node = next_node;
            count++;
        }

        return new NodeClass(prev, next_node);
    }

    static class NodeClass{
        LinkedListNode currStartNode;
        LinkedListNode newStartNode;

        public NodeClass(LinkedListNode currStartNode, LinkedListNode newStartNode) {
            this.currStartNode = currStartNode;
            this.newStartNode = newStartNode;
        }
    }
}
