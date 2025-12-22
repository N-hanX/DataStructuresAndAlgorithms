package study_program.lectureNotes.linkedLists.Rearrangement;

public class RotateList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode rotatedList = rotateRight(node0, 2);
        int a = 4;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;

        ListNode walkingNode = head;

        int lengthCounter = 0;

        while(walkingNode != null){
            walkingNode = walkingNode.next;
            lengthCounter++;
        }

        int endOfLeftPart = lengthCounter - (k % lengthCounter) - 1;

        if(lengthCounter == 1 || k % lengthCounter == 0)
            return head;

        ListNode rightNodeStarter = null;

        walkingNode = head;

        int counter = 0;

        while(counter < endOfLeftPart){
            walkingNode = walkingNode.next;
            counter++;
        }

        rightNodeStarter = walkingNode.next;
        walkingNode.next = null;

        ListNode newHead = rightNodeStarter;

        while(rightNodeStarter != null && rightNodeStarter.next != null){
            rightNodeStarter = rightNodeStarter.next;
        }
        rightNodeStarter.next = head;

        return newHead;
    }
}
