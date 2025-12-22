package study_program.lectureNotes.linkedLists.reversal;

public class ReverseList2 {
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

        ListNode reversedList = reverseBetween(node0, 2, 4);
        int a = 4;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode currNode = sentinel;
        int counter = 0;
        int leftPart = left - 1;

        while(counter < leftPart){
            currNode = currNode.next;
            counter++;
        }

        ListNode leftPartEnd = currNode;
        ListNode middlePartFirstHead = currNode.next;
        ListNode prevNode = null;
        ListNode nextNode;
        currNode = middlePartFirstHead;

        while(left <= right && currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            left++;
        }
        ListNode middlePartHead = prevNode;
        ListNode rightPartStart = currNode;
        leftPartEnd.next = middlePartHead;
        middlePartFirstHead.next = rightPartStart;

        return sentinel.next;
    }
}
