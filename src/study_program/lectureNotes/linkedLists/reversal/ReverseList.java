package study_program.lectureNotes.linkedLists.reversal;

public class ReverseList {
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

        ListNode reversedList = reverseList(node0);
        int a = 4;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode;
        ListNode currNode = head;

        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
}
