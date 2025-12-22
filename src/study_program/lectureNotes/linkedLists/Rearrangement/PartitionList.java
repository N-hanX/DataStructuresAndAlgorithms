package study_program.lectureNotes.linkedLists.Rearrangement;

public class PartitionList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode partitionedList = partition(node0, 3);
        int a = 5;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode leftPart = new ListNode(Integer.MIN_VALUE);
        ListNode rightPart = new ListNode(Integer.MAX_VALUE);

        ListNode leftSentinel = leftPart;
        ListNode rightSentinel = rightPart;

        ListNode walkingNode = head;

        while(walkingNode != null){
            ListNode currNode = walkingNode;
            walkingNode = walkingNode.next;
            currNode.next = null;

            if(currNode.val < x){
                leftPart.next = currNode;
                leftPart = leftPart.next;
            }else{
                rightPart.next = currNode;
                rightPart = rightPart.next;
            }
        }
        leftPart.next = rightSentinel.next;

        return leftSentinel.next;
    }

}
