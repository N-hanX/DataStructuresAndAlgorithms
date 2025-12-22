package study_lc;

public class ListNode {
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.next = next;
        this.val = val;
    }
}
