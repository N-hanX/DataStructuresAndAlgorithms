package trees;

public class FindModeBinary {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(2);

        left1.left = left2;
        right1.right = right2;

        int[] result = findMode(root);
        int a = 4;
    }

    public static int[] findMode(TreeNode root){
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private static int currVal;
    private static int currCount = 0;
    private static int maxCount = 0;
    private static int modeCount = 0;

    private static int[] modes;

    private static void handleValue(int val){
        if(val != currVal){
            currVal = val;
            currCount = 0;
        }

        currCount++;
        if(currCount > maxCount){
            maxCount = currCount;
            modeCount = 1;
        }else{
            if(modes != null){
                modes[modeCount] = currVal;
            }
            modeCount++;
        }
    }

    private static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
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
