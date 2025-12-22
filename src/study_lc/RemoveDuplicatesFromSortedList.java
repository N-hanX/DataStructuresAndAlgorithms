package study_lc;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = listNode;
        listNode.next.val = 1;
        listNode.next = listNode;
        listNode.next.val = 2;
        int a = 5;

    }




    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
