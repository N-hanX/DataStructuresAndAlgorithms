package study_program.lectureNotes.linkedLists.Rearrangement;

public class Merge_k_sorted_list {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);

        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(6);

        node0.next = node1;
        node1.next = node2;

        node3.next = node4;
        node4.next = node5;

        node6.next = node7;

        ListNode[] lists = new ListNode[3];
        lists[0] = node0;
        lists[1] = node3;
        lists[2] = node6;

        ListNode allList = mergeKLists(lists);
        int a = 4;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode theLastTail = new ListNode(Integer.MIN_VALUE);
        ListNode theHead = theLastTail;

        Boolean isEverythingNull = false;

        while(!isEverythingNull) {
            isEverythingNull = true;

            Integer min_val = null;
            int min_tail_ind = 0;

            for (int i = 0; i < lists.length; i++) {
                ListNode curr_tail = lists[i];
                if(curr_tail != null){
                    isEverythingNull = false;
                    if(min_val != null) {
                        if (curr_tail != null && curr_tail.val <= min_val) {
                            min_val = curr_tail.val;
                            min_tail_ind = i;
                        }
                    }else{
                        min_val = curr_tail.val;
                        min_tail_ind = i;
                    }
                }

            }

            if(min_val != null) {
                ListNode currTail = lists[min_tail_ind];
                theLastTail.next = currTail;
                currTail = currTail.next;
                lists[min_tail_ind] = currTail;
                theLastTail = theLastTail.next;
                theLastTail.next = null;
            }
        }
        return theHead.next;
    }
}
