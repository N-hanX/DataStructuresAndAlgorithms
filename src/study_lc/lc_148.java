package study_lc;

public class lc_148 {
    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(3);
//        node4.next = node5;
        ListNode node3 = new ListNode(1);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(4);
        node1.next = node2;

        ListNode head = merge(node1);
        int a = 5;
    }

    public static ListNode merge(ListNode head){
        return helper(head);
    }

    public static ListNode helper(ListNode head){
        // Base case: leaf node
        // size 0 or size 1 sublist
        if(head == null || head.next == null){
            return head;
        }
        // Recursive case: Internal node
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        ListNode head2 = tortoise.next;
        tortoise.next = null;

        ListNode l1 = helper(head);
        ListNode l2 = helper(head2);

        // merge two sorted lists
        head = mergeSortedLists(l1, l2);
        return head;
    }

    public static ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        ListNode sentinel = null; // sentinel headi gozlemci olarak kullaniyor
        ListNode tail = null; // taile ekleyerek gidiyoruz

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(tail == null){
                    tail = list1;
                    sentinel = tail;
                }else{
                    tail.next = list1;
                }

                tail = list1;
                list1 = list1.next;
                tail.next = null;
            }else{
                if(tail == null){
                    tail = list2;
                    sentinel = tail;
                }else{
                    tail.next = list2;
                }

                tail = list2;
                list2 = list2.next;
                tail.next = null;
            }
        }
        if(list1 != null){
            if(tail != null)
                tail.next = list1;
            else{
                tail = list1;
                sentinel = tail;
            }

        }
        if(list2 != null){
            if(tail != null)
                tail.next = list2;
            else{
                tail = list2;
                sentinel = tail;
            }
        }

        return sentinel;
    }
}
