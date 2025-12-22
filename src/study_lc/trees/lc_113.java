package study_lc.trees;

import study_lc.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc_113 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node7;
        node4.right = node8;
        node3.left = node5;
        node3.right = node6;
        node6.left = node9;
        node6.right = node10;

        int sum = 22;
        Stack<Integer> slate = new Stack<>();
        pathSum(node1, slate, sum);
        int a = 5;
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static void pathSum(TreeNode root, Stack<Integer> slate, int sum){
        slate.push(root.val);

        if(root.left == null && root.right == null){
            if(sum == root.val){
                Stack<Integer> copy = new Stack<>();
                for(int num: slate){
                    copy.push(num);
                }
                result.add(copy);
            }
        }
        if(root.left != null)
            pathSum(root.left, slate, sum - root.val);
        if(root.right != null)
            pathSum(root.right, slate, sum - root.val);
        slate.pop();
    }
}
