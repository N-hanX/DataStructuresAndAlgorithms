package study_program.lectureNotes.linkedLists.reversal;

public class ReorderList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        reorderList(node0);
        int a = 4;
    }

    public static void reorderList(ListNode head) {
        ListNode walkingNode = head;

        int listLength = 0;
        int counter = 0;

        while(walkingNode != null){
            walkingNode = walkingNode.next;
            counter++;
        }
        listLength = counter;

        if(listLength == 0 || listLength == 1 || listLength == 2)
            return;

        int leftPart = listLength / 2;
        int rightPart = leftPart + 1;

        counter = 0;
        walkingNode = head;
        ListNode prevNodeTemp = null;

        while(counter < leftPart){
            prevNodeTemp = walkingNode;
            walkingNode = walkingNode.next;
            counter++;
        }
        prevNodeTemp.next = null;

        ListNode rightNode = walkingNode;

        ListNode prevNode = null;
        walkingNode = rightNode;

        while(walkingNode != null){
            ListNode nextNode = walkingNode.next;
            walkingNode.next = prevNode;
            prevNode = walkingNode;
            walkingNode = nextNode;
        }

        ListNode rightHeadStart = prevNode;

        ListNode leftPartStart = head;

        ListNode sentinel = new ListNode(-1);
        ListNode tail = sentinel;

        boolean key = true;
        while(leftPartStart != null && rightHeadStart != null){
            if(key){
                tail.next = leftPartStart;
                leftPartStart = leftPartStart.next;
                tail = tail.next;
                key = false;
            }else{
                tail.next = rightHeadStart;
                rightHeadStart = rightHeadStart.next;
                tail = tail.next;
                key = true;
            }
        }
        if(rightHeadStart != null){
            tail.next = rightHeadStart;
        }
        head = sentinel.next;
    }
}
