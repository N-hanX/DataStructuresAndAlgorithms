package trees.homework;

public class ConvertSortedList2BinarySearch {
    public static void main(String[] args) {

//        LinkedListNode node1 = new LinkedListNode(-1);
//        LinkedListNode node2 = new LinkedListNode(2);
//        LinkedListNode node3 = new LinkedListNode(3);
//        LinkedListNode node4 = new LinkedListNode(5);
//        LinkedListNode node5 = new LinkedListNode(6);
//        LinkedListNode node6 = new LinkedListNode(7);
//        LinkedListNode node7 = new LinkedListNode(10);
//"head": [-1000000000, -394, -10, -9]
        LinkedListNode node1 = new LinkedListNode(-1000000000);
        LinkedListNode node2 = new LinkedListNode(-394);
        LinkedListNode node3 = new LinkedListNode(-10);
        LinkedListNode node4 = new LinkedListNode(-9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;



        BinaryTreeNode result = sorted_list_to_bst(node1, null);
        int a = 5;

    }

    static BinaryTreeNode sorted_list_to_bst(LinkedListNode head, LinkedListNode endNode) {
        if(head == endNode)
            return null;
        if(head == null)
            return null;

        LinkedListNode temp_head = new LinkedListNode(Integer.MIN_VALUE);
        temp_head.next = head;


        LinkedListNode ptr1 = temp_head;
        LinkedListNode ptr2 = temp_head;

        while(ptr1 != endNode && ptr2 != endNode){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if(ptr2 == endNode){
                break;
            }

            if(ptr2 != null){
                ptr2 = ptr2.next;
            }
        }

        LinkedListNode medianNode = ptr1;

        BinaryTreeNode node1 = new BinaryTreeNode(medianNode.value);
        if(head.value == medianNode.value){
            head.next = null;
            return node1;
        }
        node1.left = sorted_list_to_bst(head, medianNode);
        node1.right = sorted_list_to_bst(medianNode.next, endNode);

        return node1;

    }

//
//    BinaryTreeNode tree_node1 = new BinaryTreeNode(5);
//    BinaryTreeNode tree_node2 = new BinaryTreeNode(2);
//    BinaryTreeNode tree_node3 = new BinaryTreeNode(7);
//    BinaryTreeNode tree_node4 = new BinaryTreeNode(-1);
//    BinaryTreeNode tree_node5 = new BinaryTreeNode(3);
//    BinaryTreeNode tree_node6 = new BinaryTreeNode(6);
//    BinaryTreeNode tree_node7 = new BinaryTreeNode(10);
//
//    tree_node1.left = tree_node2;
//    tree_node1.right = tree_node3;
//
//    tree_node2.left = tree_node4;
//    tree_node2.right = tree_node5;
//
//    tree_node3.left = tree_node6;
//    tree_node3.right = tree_node7;

}
