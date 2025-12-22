package study_program.lectureNotes.linkedLists.Rearrangement;

public class InsertionSortList {
    public static void main(String[] args) {
//        ListNode node0 = new ListNode(4);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(1);
//
//        node0.next = node1;
//        node1.next = node2;
//        node2.next = node3;

        ListNode node0 = new ListNode(-1);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(0);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = insertionSortList(node0);
        int a = 5;
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode tail = new ListNode(Integer.MIN_VALUE);
        ListNode sentinel = tail;

        ListNode walkingNode = head;

        while(walkingNode != null){
            ListNode currNode = walkingNode;
            walkingNode = walkingNode.next;
            currNode.next = null;

            if(tail == sentinel){
                tail.next = currNode;
                tail = tail.next;
            }else{
                tail = sentinel.next;
                ListNode prevNode = sentinel;

                while(tail != null){
                    if(tail.val >= currNode.val){
                        ListNode nextNode = tail;
                        prevNode.next = currNode;
                        currNode.next = nextNode;
                        break;
                    }else if(tail.next == null){
                        tail.next = currNode;
                        break;
                    }
                    prevNode = tail;
                    tail = tail.next;
                }

            }
        }

        return sentinel.next;
    }
}
