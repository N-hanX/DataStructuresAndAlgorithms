package study_program.problemSet.tree;

public class Convert_A_BinaryTreeInto_A_CircularDoublyLinkedList {
    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        node4.left = node2;
        node2.left = node1;
        node2.right = node3;
        node4.right = node5;

        BinaryTreeNode result = binary_tree_to_cdll(node4);

        int a;
    }
    static BinaryTreeNode binary_tree_to_cdll(BinaryTreeNode root) {
        linkedListBuilder(root, null, null);

        return null;
    }

    static void linkedListBuilder(BinaryTreeNode root, BinaryTreeNode smaller_node, BinaryTreeNode bigger_node) {

    }

    static BinaryTreeNode findTheBiggestOfLeft(BinaryTreeNode root){
        if(root == null)
            return null;

        if(root != null && root.right == null){
            return root;
        }
        return findTheBiggestOfLeft(root.right);
    }

    static BinaryTreeNode findTheSmallestOfRight(BinaryTreeNode root){
        if(root != null && root.left == null){
            return root;
        }

        if(root == null)
            return null;

        return findTheSmallestOfRight(root.left);
    }
}
