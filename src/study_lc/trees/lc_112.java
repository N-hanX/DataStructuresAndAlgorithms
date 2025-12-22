package study_lc.trees;

import study_lc.TreeNode;

public class lc_112 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node7;
        node4.right = node8;
        node3.left = node5;
        node3.right = node6;
        node6.right = node9;

        int sum = 22;
        boolean result = pathSum(node1, sum);
        int a = 5;
    }

    public static boolean pathSum(TreeNode node, int sum){
        if(node == null){
            return false;
        }
        // 1. soruyu anliyoruz. Netlestiriyoruz.
        // 2. algoritmayi yaziyoruz.
        // 3. edge case'leri dusunuyoruz.
        // 4. test case'leri yaziyoruz.

        if(node.left == null && node.right == null){
            if(node.val == sum){
                return true;
            }
        }
        boolean foundLeft = false;
        boolean foundRight = false;

//        if(node.left != null)
        if (node.left != null)
            foundLeft = pathSum(node.left, sum - node.val);
        if(node.right != null)
            foundRight = pathSum(node.right, sum - node.val);

        return foundLeft || foundRight;
    }
}
