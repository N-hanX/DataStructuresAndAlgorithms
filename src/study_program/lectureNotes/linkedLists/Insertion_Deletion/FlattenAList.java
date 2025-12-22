package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class FlattenAList {
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
        LinkedListNode node11 = new LinkedListNode(11);
        LinkedListNode node12 = new LinkedListNode(12);

        LinkedListNode node13 = new LinkedListNode(13);

        node1.next = node2;
        node2.next = node3;
        node2.child = node5;
        node3.next = node4;

        node4.next = null;
        node4.child = node7;

        node5.next = node6;
        node5.child = node10;

        node7.next = node8;
        node7.child = node11;
        node8.next = node9;

        node11.next = node12;
        node12.next = node13;

        LinkedListNode flattened_list = flattenTheList(node1);
        int a = 5;
    }

    static LinkedListNode flattenTheList(LinkedListNode node) {
        LinkedListNode head = node;
        LinkedListNode tail = getTail(node) ;

        while(node != null){
            if(node.child != null){
                tail.next = node.child;
                tail = getTail(node.child);
            }
            node = node.next;
        }
        return head;
    }

    static LinkedListNode getTail(LinkedListNode node){
        if(node == null)
            return null;

        while(node.next != null)
            node = node.next;
        return node;
    }


}
