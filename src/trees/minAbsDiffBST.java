package trees;

public class minAbsDiffBST {
    static int min;
    static Integer prev;
    public static void main(String[] args) {
        min = Integer.MAX_VALUE;
        prev = null;
        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(48);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(12);
        TreeNode right2 = new TreeNode(49);

        right1.left = left2;
        right1.right = right2;

        int a = getMinDiff(root);
        int b = 4;
    }

    public static int getMinDiff(TreeNode root){
        if(root == null) return min;

        getMinDiff(root.left);

        if(prev != null){
            min = Math.min(min , root.val - prev);

        }
        prev = root.val;
        getMinDiff(root.right);
        return min;
    }


    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int _val)
        {
            val = _val;
            left = null;
            right = null;
        }
    }

}
