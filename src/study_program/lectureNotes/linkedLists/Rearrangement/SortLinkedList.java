package study_program.lectureNotes.linkedLists.Rearrangement;

public class SortLinkedList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(7);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(11);

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(10);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(0);

        ListNode node9 = new ListNode(4);
        ListNode node10 = new ListNode(12);
        ListNode node11 = new ListNode(13);
        ListNode node12 = new ListNode(3);

        node0.next = node1;
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

        ListNode startNode = sortList(node0);
        int a = 4;
    }

    public static ListNode sortList(ListNode head) {
        ListNode startNode = head;

        return mergeSortLinkedList(startNode);
    }

    public static ListNode mergeSortLinkedList(ListNode startNode) {
        if(startNode == null || startNode.next == null)
            return startNode;

        ListNode slowPointer = startNode;
        ListNode fasterPointer = startNode;

        while(fasterPointer.next != null && fasterPointer.next.next != null){
            slowPointer = slowPointer.next;
            fasterPointer = fasterPointer.next;
            if(fasterPointer != null)
                fasterPointer = fasterPointer.next;
            else
                break;
        }

        ListNode rightPart = slowPointer.next;
        slowPointer.next = null;

        ListNode leftNode = mergeSortLinkedList(startNode);
        System.out.println("***");

        if(leftNode != null)
            System.out.println("left: " + leftNode.val);

        ListNode rightNode = mergeSortLinkedList(rightPart);
        if(rightNode != null)
            System.out.println("right: " + rightNode.val);

        ListNode sortedNode = mergeTwoSortedLinkedList(leftNode, rightNode);
        return sortedNode;
    }

    public static  ListNode mergeTwoSortedLinkedList(ListNode tail1, ListNode tail2){
        if(tail1 == null){
            return tail2;
        }

        if(tail2 == null){
            return tail1;
        }

        ListNode tail = null;
        ListNode head = null;

        while(tail1 != null && tail2 != null){
            if(tail1.val <= tail2.val){
                if(tail == null){
                    tail = tail1;
                    head = tail;
                    tail1 = tail1.next;
                }else{
                    tail.next = tail1;
                    tail1 = tail1.next;
                    tail = tail.next;
                }
            }else{
                if(tail == null){
                    tail = tail2;
                    head = tail;
                    tail2 = tail2.next;
                }else{
                    tail.next = tail2;
                    tail2 = tail2.next;
                    tail = tail.next;
                }
            }
        }

        if(tail1 != null){
            tail.next = tail1;
        }else if(tail2 != null){
            tail.next = tail2;
        }

        return head;
    }
}
