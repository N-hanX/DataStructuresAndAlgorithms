package study_program.problemSet.linkedList_stack_queue;

public class FindMiddleNodeOf_A_LinkedList {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
//        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        node3.next = node5;

        LinkedListNode result = find_middle_node(node1);
        int a = 5;
    }

    static LinkedListNode find_middle_node(LinkedListNode head) {
        LinkedListNode pointer1 = head;
        LinkedListNode pointer2 = head;

        while(pointer1 != null && pointer2 != null && pointer1.next != null && pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
            if(pointer2 != null){
                pointer2 = pointer2.next;
            }
        }

        return pointer1;
    }
}
