package study_lc;

public class SameTree {
    public static void main(String[] args) {

        int[][] grid = {{0,1,1},{1,1,1},{1,0,0}};

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);

        treeNode1.left = new TreeNode(2);
        treeNode2.left = new TreeNode(2);

        treeNode1.right = new TreeNode(3);
        treeNode2.right = new TreeNode(3);

        int a = 5;
    }



    public static class TreeNode {
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
