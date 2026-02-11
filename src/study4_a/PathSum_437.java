package study4_a;

public class PathSum_437 {
// for testing, go the question page
    public class TreeNode {
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

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;

        // this means the path could be in left tree or right tree part of a node, or the node could be the parent node of the path.
        return pathSum(root.left, targetSum) +
                pathSum(root.right, targetSum) +
                subPathSum(root, targetSum);
    }

    public int subPathSum(TreeNode root, long currSum){
        if(root == null){
            return 0;
        }

        int count = 0;
        if(root.val == currSum){
            count = 1;
        }

        count += subPathSum(root.left, currSum - root.val);
        count += subPathSum(root.right, currSum - root.val);
        return count;
    }
}
