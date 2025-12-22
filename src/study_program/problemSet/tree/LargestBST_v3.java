package study_program.problemSet.tree;

public class LargestBST_v3 {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(100);
        BinaryTreeNode node2 = new BinaryTreeNode(100);
        BinaryTreeNode node3 = new BinaryTreeNode(100);
        BinaryTreeNode node4 = new BinaryTreeNode(400);
        BinaryTreeNode node5 = new BinaryTreeNode(500);
        BinaryTreeNode node6 = new BinaryTreeNode(600);
        BinaryTreeNode node7 = new BinaryTreeNode(700);

        node1.left = node2;
        node2.left = node3;
//        node2.right = node4;
//        node1.right = node5;
//        node5.left = node6;
//        node5.right = node7;

        Integer result = find_largest_bst(node1);

        int a = 4;
    }

    static Integer largest_val;
    static Integer find_largest_bst(BinaryTreeNode root) {
        largest_val = 0;
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return largest_val;
    }

    static Integer helper(BinaryTreeNode currNode, int min_val_for_bst, int max_val_for_bst){
        if(currNode == null)
            return 0;


        Integer left_bst, right_bst;
        if(!(currNode.value <= max_val_for_bst && currNode.value >= min_val_for_bst )){
            left_bst = helper(currNode.left, Integer.MIN_VALUE, currNode.value);
            right_bst = helper(currNode.right, currNode.value, Integer.MAX_VALUE);
        }else{
            left_bst = helper(currNode.left, min_val_for_bst, currNode.value);
            right_bst = helper(currNode.right, currNode.value, max_val_for_bst);
        }

        if(left_bst >= 0 && right_bst >= 0
            && (currNode.left == null || currNode.value >= currNode.left.value)
                &&
            (currNode.right == null || currNode.value <= currNode.right.value)){
            if( largest_val < left_bst + right_bst + 1){
                largest_val = left_bst + right_bst + 1;
            }
            return left_bst + right_bst + 1;
        }
        return -1;
    }
}
