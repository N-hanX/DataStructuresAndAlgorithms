package study_program.problemSet.linkedList_stack_queue;

public class ZipLinkedListFromTwoEnds {
    public static void main(String[] args) {
//        {
//            "head": [1, 2, 3, 4, 5, 6]
//        }

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

        LinkedListNode head = zip_given_linked_list(node1);

        int a = 5;
    }

    static LinkedListNode zip_given_linked_list(LinkedListNode head) {
        if(head == null)
            return null;

        LinkedListNode ptr = head;

        int total_count = 0;
        while(ptr != null){
            ptr = ptr.next;
            total_count++;
        }

        int left_part_start = 1;
        int left_part_end = total_count/2;
        int right_part_start = total_count / 2 + 1;

        int counter = 1;

        ptr = head;
        LinkedListNode last_node_before_right_part = head;
        while(ptr != null && counter < right_part_start){
            last_node_before_right_part = ptr;
            ptr = ptr.next;
            counter++;
        }

        LinkedListNode right_head = ptr;
        last_node_before_right_part.next = null;

        LinkedListNode left_ptr = head;
        LinkedListNode prev_ptr = new LinkedListNode(Integer.MIN_VALUE);

        while(left_part_start <= left_part_end && left_ptr != null){
            prev_ptr = left_ptr;
            LinkedListNode next_left_ptr = left_ptr.next;
            LinkedListNode right_node = find_right_node_and_arrange_right_part(right_head);
            left_ptr.next = right_node;

            if(right_node != null)
                right_node.next = next_left_ptr;

            prev_ptr = right_node;
            left_part_start++;
            left_ptr = next_left_ptr;
        }

        if(total_count % 2 == 1)
            prev_ptr.next = right_head;

        return head;
    }

    static LinkedListNode find_right_node_and_arrange_right_part(LinkedListNode right_head){
        LinkedListNode prev_right_node = new LinkedListNode(Integer.MIN_VALUE);
        LinkedListNode right_ptr = right_head;

        while(right_ptr != null && right_ptr.next != null){
            prev_right_node = right_ptr;
            right_ptr = right_ptr.next;
        }
        prev_right_node.next = null;

        return right_ptr;
    }
}
