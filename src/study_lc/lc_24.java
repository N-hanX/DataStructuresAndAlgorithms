package study_lc;

public class lc_24 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
//        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        ListNode head = swapPairs(node1);
        int a = 5;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel;

        while (prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = first.next;
            ListNode third = second.next;

            prev.next = second;
            second.next = first;
            first.next = third;

            prev = prev.next.next;
        }
        return sentinel.next;
    }
}
