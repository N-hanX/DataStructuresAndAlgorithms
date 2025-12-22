package study_lc;

public class lc_708 {


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(3, head);
        ListNode node4 = new ListNode(3, node1);
        head.next = node4;
        head = insertCircularList(head, 2);


//        ListNode head = insertCircularList(null, 2);
        int a =5;
    }

    public static ListNode insertCircularList(ListNode head, int val){
        ListNode newNode = new ListNode(val);

        if(head == null){ //size 0
            head = newNode;
            head.next = newNode;
            return head;
        }
        if(head.next == null){//size 1
            head.next = newNode;
            newNode.next = head;
            return head;
        }

        ListNode currNode = head.next;
        ListNode predNode = head;

        // tum nodelar ayni ise bir yerde durmak lazim. 2. condition icin
        while(currNode.val >= predNode.val && currNode != head ){
            predNode = predNode.next;
            currNode = currNode.next;
        }

        if(val > predNode.val){
            predNode.next = newNode;
            newNode.next = currNode;
            return head;
        }

        while(currNode.val < val){
            currNode = currNode.next;
            predNode = predNode.next;
        }

        predNode.next = newNode;
        newNode.next = currNode;
        return head;
    }
}
