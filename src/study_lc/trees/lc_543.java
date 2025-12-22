package study_lc.trees;

import study_lc.TreeNode;

public class lc_543 {

    private int maxDiameter = 0;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;

        lc_543 l = new lc_543();

        l.helperDiameterOfBinaryTree(node1);
        int a = 5;
    }



    public int helperDiameterOfBinaryTree(TreeNode node){
        // I clarify the question.
        // The question also asks the node which its length of all left and right children.
        if(node.left == null && node.right == null){
            return 0;
        }

        int theLeftPart = 0;
        int theRightPart = 0;

        if(node.left != null)
            theLeftPart = 1 + helperDiameterOfBinaryTree(node.left);

        if(node.right != null)
            theRightPart = 1 + helperDiameterOfBinaryTree(node.right);

        maxDiameter = Math.max(theLeftPart + theRightPart, maxDiameter);
        return Math.max(theLeftPart, theRightPart);
    }
}
