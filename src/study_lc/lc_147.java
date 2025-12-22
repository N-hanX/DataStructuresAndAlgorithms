package study_lc;

public class lc_147 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(5);
        node2.next = node3;
        ListNode node1 = new ListNode(-1);
        node1.next = node2;

        ListNode head = insertionSort(node1);
        int a = 5;
    }

    public static ListNode insertionSort(ListNode head){
        ListNode sentinel = null;
        ListNode currInsertionNode = null;
        ListNode tail = head;
        ListNode pred_insertion_step = null;
        ListNode next_insertion_step = null;


        while(tail != null){
            System.out.println(tail.val);
            if(sentinel == null){
                sentinel = tail;
                tail = tail.next;
                sentinel.next = null;
            }else if(sentinel.val >= tail.val){
                next_insertion_step = sentinel;
                sentinel = tail;
                tail = tail.next;
                sentinel.next = next_insertion_step;
            }else if(sentinel.val < tail.val){
                pred_insertion_step = null;
                currInsertionNode = sentinel;
                while(currInsertionNode != null && currInsertionNode.val < tail.val){
                    pred_insertion_step = currInsertionNode;
                    currInsertionNode = currInsertionNode.next;
                }
                pred_insertion_step.next = tail;
                if(tail.next == null){
                    tail.next = currInsertionNode;
//                    tail = currInsertionNode;
                    tail = null;
                }else{
                    tail = tail.next;
                    pred_insertion_step.next.next = currInsertionNode;
                }
            }
        }
        return sentinel;
    }
}
