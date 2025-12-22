package study_program.lectureNotes.linkedLists.reversal;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node0.next = node1;
        node1.next = node3;
//        node2.next = node3;
        node3.next = node4;

        boolean result = isPalindrome(node0);
        int a = 4;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode walkingNode = head;
        int lengthOfList = 0;

        while(walkingNode != null){
            walkingNode = walkingNode.next;
            lengthOfList++;
        }

        if(lengthOfList == 1){
            return true;
        }

        if(lengthOfList == 2){
            if(head.val != head.next.val){
                return false;
            }else{
                return true;
            }
        }

        int leftPartLength = -1;

        leftPartLength = lengthOfList / 2;

        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        int counter = 0;
        while(counter < leftPartLength){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            counter++;
        }

        ListNode rightPartHead = null;

        if(lengthOfList % 2 == 1){
            rightPartHead = nextNode.next;
        }else{
            rightPartHead = nextNode;
        }

        ListNode leftPartHead = prevNode;

        while(leftPartHead != null && rightPartHead != null){
            if(leftPartHead.val != rightPartHead.val){
                return false;
            }
            leftPartHead = leftPartHead.next;
            rightPartHead = rightPartHead.next;
        }

        return true;
    }
}
