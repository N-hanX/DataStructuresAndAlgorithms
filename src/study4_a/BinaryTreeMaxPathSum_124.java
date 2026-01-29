package study4_a;

public class BinaryTreeMaxPathSum_124 {
    static void main() {
        // testcode is hard to write so check the official page
    }

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

    long max_val;
    public int maxPathSum(TreeNode root) {
        max_val = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return (int)max_val;
    }

    public Integer maxPathSumHelper(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            max_val = Math.max(root.val, max_val);
            return root.val;
        }

        Integer maxLeft = maxPathSumHelper(root.left);
        Integer maxRight = maxPathSumHelper(root.right);

        if(maxLeft != null && maxRight != null)
            max_val = Math.max(maxLeft + maxRight + root.val, max_val);

        if(maxLeft != null){
            max_val = Math.max(maxLeft + root.val, max_val);
            max_val = Math.max(maxLeft, max_val);
        }

        if(maxRight != null){
            max_val = Math.max(maxRight + root.val, max_val);
            max_val = Math.max(maxRight, max_val);
        }

        max_val = Math.max(root.val, max_val);

        return findBestSubPath(maxLeft, maxRight, root.val);
    }

    public int findBestSubPath( Integer maxLeft,  Integer maxRight, int root){
        int temp1 = Integer.MIN_VALUE;
        int temp2 = Integer.MIN_VALUE;

        if(maxLeft != null)
            temp1 = Math.max(root, maxLeft+root);
        else
            temp1 = root;

        if(maxRight != null)
            temp2= Math.max(temp1, maxRight+root);
        else
            temp2 = temp1;

        return temp2;
    }
}
