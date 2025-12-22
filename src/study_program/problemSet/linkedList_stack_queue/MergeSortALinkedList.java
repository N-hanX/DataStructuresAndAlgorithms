package study_program.problemSet.linkedList_stack_queue;

public class MergeSortALinkedList {
    public static void main(String[] args) {
        //"head": [0, 1, 10, 7]
//        LinkedListNode node0 = new LinkedListNode(0);
//        LinkedListNode node1 = new LinkedListNode(1);
//        LinkedListNode node2 = new LinkedListNode(10);
//        LinkedListNode node3 = new LinkedListNode(7);
//
//        node0.next = node1;
//        node1.next = node2;
//        node2.next = node3;

//        LinkedListNode node0 = new LinkedListNode(1);
//        LinkedListNode node1 = new LinkedListNode(-2);
//
//        node0.next = node1;

        LinkedListNode node0 = new LinkedListNode(1);
        LinkedListNode node1 = new LinkedListNode(2);
        LinkedListNode node2 = new LinkedListNode(3);

        node0.next = node1;
        node1.next = node2;

        LinkedListNode result = merge_sort(node0);

        int a = 4;
    }

    static LinkedListNode merge_sort(LinkedListNode head) {
        return merge_sort_helper(head);
    }

    static LinkedListNode findMiddleNode(LinkedListNode head){
        LinkedListNode prev = new LinkedListNode(-1);
        prev.next = head;
        LinkedListNode ptr1 = prev;
        LinkedListNode ptr2 = prev;

        while(ptr1.next != null && ptr2 != null && ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if(ptr2 != null)
                ptr2 = ptr2.next;
        }
        return ptr1;
    }

    static LinkedListNode merge_sort_helper(LinkedListNode head){
        if(head == null || head.next == null)
            return head;

        LinkedListNode prev_head2 = findMiddleNode(head);
        LinkedListNode head2 = prev_head2.next;
        prev_head2.next = null;

        LinkedListNode result1 = merge_sort_helper(head);
        LinkedListNode result2 = merge_sort_helper(head2);

        LinkedListNode result =  mergeSortedLists(result1, result2);
        return result;
    }

    static LinkedListNode mergeSortedLists(LinkedListNode head1, LinkedListNode head2){
        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;

        LinkedListNode temp = new LinkedListNode(-1);
        LinkedListNode the_prev_head = temp;

        while(node1 != null && node2 != null) {
            LinkedListNode next_node2 = node2.next;
            LinkedListNode next_node1 = node1.next;

            if (node2.value < node1.value) {
                temp.next = node2;
                temp = temp.next;
                temp.next = null;

                node2 = next_node2;
            }else {
                temp.next = node1;
                temp = temp.next;
                temp.next = null;

                node1 = next_node1;
            }
        }

        if(node1 != null){
            temp.next = node1;
        }

        if(node2 != null){
            temp.next = node2;
        }

        return the_prev_head.next;
    }
}
