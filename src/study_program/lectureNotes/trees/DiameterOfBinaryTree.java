package study_program.lectureNotes.trees;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node11 = new TreeNode(11);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node2 = new TreeNode(2);
//
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node13 = new TreeNode(13);
//        TreeNode node4_2 = new TreeNode(4);
//        TreeNode node1 = new TreeNode(1);
//
//        node5.left = node4;
//        node4.left = node11;
//        node11.left = node7;
//        node11.right = node2;
//
//        node5.right = node8;
//        node8.left = node13;
//        node8.right = node4_2;
//        node4_2.right = node1;
//

//        int result = diameterOfBinaryTree(node5);


        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        node1.left = node2;

        int result2 = diameterOfBinaryTree(node1);

        int a = 4;
    }

    static int max_value;

    public static int diameterOfBinaryTree(TreeNode root) {
        max_value = 0;
        helper(root);
        return max_value;
    }

    public static int helper(TreeNode root){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null){
            return 0;
        }

        int leftPart = 0;
        int rightPart = 0;

        if(root.left != null){
            leftPart = 1 + helper(root.left);
        }

        if(root.right != null){
            rightPart = 1 + helper(root.right);
        }

        int curr_diameter = leftPart + rightPart;

        max_value = Math.max(max_value, curr_diameter);

        return Math.max(leftPart, rightPart);
    }
}
