package study_program.problemSet.tree;

public class LargestBST {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(450);
        BinaryTreeNode node2 = new BinaryTreeNode(200);
        BinaryTreeNode node3 = new BinaryTreeNode(300);
        BinaryTreeNode node4 = new BinaryTreeNode(400);
        BinaryTreeNode node5 = new BinaryTreeNode(500);
        BinaryTreeNode node6 = new BinaryTreeNode(470);
        BinaryTreeNode node7 = new BinaryTreeNode(700);

        node1.left = node3;
        node3.left = node2;
        node3.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;

        Integer result = find_largest_bst(node1);
        int a = 4;
    }

    static int counter;

    static Integer find_largest_bst(BinaryTreeNode root) {
        counter = 0;
        Boolean its_bst = helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        if(its_bst) {
            return counter;
        }

        return Math.max(find_largest_bst(root.left), find_largest_bst(root.right));
    }

    static Boolean helper(BinaryTreeNode root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min || root.value > max ){
            return false;
        }
        counter++;

        System.out.println("currNode: " + root.value + " curr counter: " + counter);
        Boolean left_is_bst = helper(root.left, min, root.value);

        if(left_is_bst){
            return helper(root.right, root.value, max);
        }
        return false;
    }

}
