package study_program.lectureNotes.trees;


public class PathSum {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);

        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);


        node5.left = node4;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;

        node5.right = node8;
        node8.left = node13;
        node8.right = node4_2;
        node4_2.right = node1;

        Boolean result = hasPathSum(node5, 22);

        Boolean result2 = hasPathSum(null, 22);
        int a = 4;
    }

    static boolean the_result;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        the_result = false;
        if(root == null){
            return the_result;
        }

        dfs(root, targetSum);
        return the_result;
    }

    public static void dfs(TreeNode root, int targetSum) {
        if(the_result)
            return;

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0) {
                the_result = true;
            }
            return;
        }

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
