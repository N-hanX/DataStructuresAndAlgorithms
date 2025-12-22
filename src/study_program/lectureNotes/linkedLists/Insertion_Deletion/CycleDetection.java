package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class CycleDetection {

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
        node8.next = node4;

        boolean has_cycle_result = hasCycle(node1);
        int a = 5;
    }

    public static boolean hasCycle(LinkedListNode node){
        LinkedListNode slowPointer = node;
        LinkedListNode fastPointer = node;

        while(fastPointer != null && fastPointer.next != null ){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;

            if(slowPointer == fastPointer)
                return true;
        }
        return false; //

    }
}
