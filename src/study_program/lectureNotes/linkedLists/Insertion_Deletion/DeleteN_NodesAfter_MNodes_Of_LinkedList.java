package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class DeleteN_NodesAfter_MNodes_Of_LinkedList {
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
        node3.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        node8.next = node9;
        node9.next = node10;

        node10.next = node11;
        node11.next = node12;
        node12.next = node13;

        LinkedListNode result = deleteAsSpecified(node1, 1, 2);

        int a = 5;
    }

    public static LinkedListNode deleteAsSpecified(LinkedListNode head, int m, int n){
        LinkedListNode prevNode = new LinkedListNode(-101);
        LinkedListNode prevHeadNode = prevNode;
        LinkedListNode walkingNode = head;
        prevNode.next = head;

        boolean key = true; // true is m movement, false is n delete;

        while(walkingNode != null){
            int counter = 0;

            if(key){
                while(counter < m && walkingNode != null){
                    prevNode.next = walkingNode;
                    prevNode = prevNode.next;
                    walkingNode = walkingNode.next;
                    counter++;
                }
                key = false;
            }else{
                while(counter < n && walkingNode != null){
                    walkingNode = walkingNode.next;
                    counter++;
                }
                prevNode.next = null;
                key = true;
            }
        }
        return prevHeadNode.next;
    }

}
