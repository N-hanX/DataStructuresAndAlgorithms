package study_lc;

public class lc_1474 {
    public static void main(String[] args) {
        ListNode node13 = new ListNode(13);
        ListNode node12 = new ListNode(12);
        node12.next = node13;
        ListNode node11 = new ListNode(11);
        node11.next = node12;
        ListNode node10 = new ListNode(10);
        node10.next = node11;
        ListNode node9 = new ListNode(9);
        node9.next = node10;
        ListNode node8 = new ListNode(8);
        node8.next = node9;
        ListNode node7 = new ListNode(7);
        node7.next = node8;
        ListNode node6 = new ListNode(6);
        node6.next = node7;
        ListNode node5 = new ListNode(5);
        node5.next = node6;
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        ListNode head = node1;

        head = deleteN_nodes_after_mNodes(head, 2, 3);
        int a = 5;
    }

    public static ListNode deleteN_nodes_after_mNodes(ListNode head, int m, int n){
        ListNode sentinel = null;
        ListNode curr = head;
        ListNode p;
        ListNode pred = null;

        while(curr != null) {
            int count = 1;

            while (count <= m && curr != null) {
                if (sentinel == null) {
                    sentinel = curr;
                }
                pred = curr;
                curr = curr.next;
                count++;
            }

            count = 1;
            p = curr;
            while (count <= n && p != null) {
                p = p.next;
                count++;
            }
            pred.next = p;
            curr = p;
        }
        return sentinel;
    }
}
