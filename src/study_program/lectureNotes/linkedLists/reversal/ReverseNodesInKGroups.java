package study_program.lectureNotes.linkedLists.reversal;

public class ReverseNodesInKGroups {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;

        ListNode lastList = reverseKGroup(node0, 3);
        int a = 4;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int counter = 0;
        ListNode walkingNode = head;

        while(walkingNode != null){
            walkingNode = walkingNode.next;
            counter++;
        }

        int listLength = counter;
        if(listLength < k)
            return head;

        int ind_counter = 0;
        ListNode sentinel = new ListNode(-1);
        ListNode sub_head = sentinel;

        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode prevFirstSubHead = sentinel;

        while(ind_counter < listLength){
            int sub_ind_counter = 0;

            ListNode theNextEnd = currNode;

            if(listLength - ind_counter >= k) {
                while (sub_ind_counter < k) {
                    ListNode nextNode = currNode.next;
                    currNode.next = prevNode;
                    prevNode = currNode;
                    currNode = nextNode;
                    ind_counter++;
                    sub_ind_counter++;
                }

                prevFirstSubHead.next = prevNode;
                prevFirstSubHead = theNextEnd;
                prevNode = null;
            }else{
                prevFirstSubHead.next = currNode;
                ind_counter = listLength;
            }
        }
        return sentinel.next;
    }
}
