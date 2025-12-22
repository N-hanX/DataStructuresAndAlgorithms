package study_program.lectureNotes.linkedLists.Insertion_Deletion;

public class RemoveDuplicatesFromSortedList2 {
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

        LinkedListNode result = deleteDuplicates(node1);

        int a = 5;
    }

    public static LinkedListNode deleteDuplicates(LinkedListNode head) {
        LinkedListNode prevNode = new LinkedListNode(-1);
        LinkedListNode prevHeadNode = prevNode;
        prevNode.next = head;
        LinkedListNode walkingNode = head;

        while(walkingNode != null){
            boolean isDuplicate = isTheNodeDuplicate(walkingNode);
            if(isDuplicate){
                int valueOfDuplicateNode = walkingNode.next.value;
                System.out.println("duplicate: " + valueOfDuplicateNode);
                LinkedListNode findTheDifferentNode = walkingNode.next;
                while(findTheDifferentNode != null && findTheDifferentNode.value == valueOfDuplicateNode){
                    findTheDifferentNode = findTheDifferentNode.next;
                }
                walkingNode = findTheDifferentNode;
                prevNode.next = null;
            }else{
                prevNode.next = walkingNode;
                prevNode = prevNode.next;
                walkingNode = walkingNode.next;
            }
        }
        return prevHeadNode.next;
    }

    public static boolean isTheNodeDuplicate(LinkedListNode node){
        if(node != null && node.next != null){
            if(node.value != node.next.value){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}
