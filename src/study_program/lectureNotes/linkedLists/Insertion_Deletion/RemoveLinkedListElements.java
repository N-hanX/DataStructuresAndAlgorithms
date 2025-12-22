package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(6);

        LinkedListNode node4 = new LinkedListNode(3);
        LinkedListNode node5 = new LinkedListNode(4);
        LinkedListNode node6 = new LinkedListNode(5);
        LinkedListNode node7 = new LinkedListNode(6);
        LinkedListNode node8 = new LinkedListNode(6);
        LinkedListNode node9 = new LinkedListNode(6);

        LinkedListNode node10 = new LinkedListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        node8.next = node9;
        node9.next = node10;

        removeElements(node1, 6);
        int a = 5;
    }

    public static LinkedListNode removeElements(LinkedListNode head, int val) {
        LinkedListNode temp_head = head;
        LinkedListNode prev_head = new LinkedListNode(-1);
        LinkedListNode prev_node = prev_head;
        prev_node.next = temp_head;
        LinkedListNode walkingNode = head;

        while(walkingNode != null){
            if(walkingNode.value == val){
                prev_node.next = walkingNode.next;
            }else{
                prev_node = prev_node.next;
            }
            walkingNode = walkingNode.next;
        }
        return prev_head.next;
    }
}
