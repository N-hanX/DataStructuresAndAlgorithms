package study_program.lectureNotes.linkedLists.Rearrangement;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode ptr1_node1 = new ListNode(1);
        ListNode ptr1_node2 = new ListNode(2);
        ListNode ptr1_node3 = new ListNode(4);

        ptr1_node1.next = ptr1_node2;
        ptr1_node2.next = ptr1_node3;

        ListNode ptr2_node1 = new ListNode(0);
        ListNode ptr2_node2 = new ListNode(3);
        ListNode ptr2_node3 = new ListNode(4);

        ptr2_node1.next = ptr2_node2;
        ptr2_node2.next = ptr2_node3;

//        ListNode ptr1_node1 = new ListNode(2);
//        ListNode ptr2_node1 = new ListNode(1);

        ListNode all_list = mergeTwoLists(ptr1_node1, ptr2_node1);

        int a = 5;

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        if(list1 != null && list2 == null)
            return list1;

        if(list1 == null && list2 != null)
            return list2;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(head == null){
                    head = list1;
                    tail = list1;
                }else{
                    tail.next = list1;
                    tail = tail.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = list2;
                    tail = list2;
                }else{
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }

        if(list1 != null){
            tail.next = list1;
        }else if(list2 != null){
            tail.next = list2;
        }
        return head;
    }
}
