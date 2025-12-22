package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node7 = new LinkedListNode(7);
        LinkedListNode node8 = new LinkedListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        deleteNode(node4);
        int a = 5;
    }

    public static void deleteNode(LinkedListNode node) {
        while(node.next != null){
            int the_next_val = node.next.value;
            node.value = the_next_val;

            if(node != null && node.next != null && node.next.next == null){
                node.next = null;
                break;
            }

            node = node.next;
        }
        int a = 5;
    }

}
