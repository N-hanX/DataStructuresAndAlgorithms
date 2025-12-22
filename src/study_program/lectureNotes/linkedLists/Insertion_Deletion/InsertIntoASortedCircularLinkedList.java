package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class InsertIntoASortedCircularLinkedList {
    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(8);
        LinkedListNode node2 = new LinkedListNode(10);
        LinkedListNode node3 = new LinkedListNode(12);
        LinkedListNode node4 = new LinkedListNode(15);

        LinkedListNode node5 = new LinkedListNode(30);
        LinkedListNode node6 = new LinkedListNode(50);
        LinkedListNode node7 = new LinkedListNode(80);
        LinkedListNode node8 = new LinkedListNode(101);
//        LinkedListNode node9 = new LinkedListNode(0);
//        LinkedListNode node10 = new LinkedListNode(2);
//        LinkedListNode node11 = new LinkedListNode(4);
//
//        LinkedListNode node12 = new LinkedListNode(5);
//        LinkedListNode node13 = new LinkedListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node1;
//
//        node8.next = node9;
//        node9.next = node10;
//
//        node10.next = node11;
//        node11.next = node12;
//        node12.next = node13;
//
//        node13.next = node1;

//        LinkedListNode last_list = insertion(node1, 3);
//        LinkedListNode last_list = insertion(node1, 7);
//        LinkedListNode last_list = insertion(node1, 9);


        LinkedListNode last_list = insertion(node1, 3);
        int a = 4;
    }

    public static LinkedListNode insertion(LinkedListNode head, int new_value){
        LinkedListNode new_node = new LinkedListNode(new_value);
        if(head == null){
            new_node.next = new_node;
            return new_node;
        }
        LinkedListNode walkingNode = head;

        while(walkingNode.next != head){
            if(walkingNode.value < new_value && walkingNode.next.value > new_value){

                LinkedListNode prev_next_node = walkingNode.next;
                walkingNode.next = new_node;
                new_node.next = prev_next_node;
                break;
            }
            walkingNode = walkingNode.next;
        }

        if(walkingNode.next == head){
            walkingNode.next = new_node;
            new_node.next = head;
        }
        return head;
    }

}
