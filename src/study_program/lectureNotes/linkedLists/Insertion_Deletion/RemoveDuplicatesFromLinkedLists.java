package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class RemoveDuplicatesFromLinkedLists {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node3 = new LinkedListNode(2);
        LinkedListNode node4 = new LinkedListNode(2);

        LinkedListNode node5 = new LinkedListNode(3);
        LinkedListNode node6 = new LinkedListNode(4);
        LinkedListNode node7 = new LinkedListNode(4);
        LinkedListNode node8 = new LinkedListNode(5);
        LinkedListNode node9 = new LinkedListNode(5);
        LinkedListNode node10 = new LinkedListNode(6);
        LinkedListNode node11 = new LinkedListNode(6);

        LinkedListNode node12 = new LinkedListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        node8.next = node9;
        node9.next = node10;

        node10.next = node11;
        node11.next = node12;

        deleteDuplicates(node1);

        int a = 5;
    }

    public static void deleteDuplicates(LinkedListNode head) {
        LinkedListNode walkingNode = head;

        while(walkingNode != null && walkingNode.next != null){
            if(walkingNode.value == walkingNode.next.value){
                walkingNode.next = walkingNode.next.next;
            }else{
                walkingNode = walkingNode.next;
            }
        }
    }

}
