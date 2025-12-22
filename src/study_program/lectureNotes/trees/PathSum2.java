package study_program.lectureNotes.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum2 {
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

        List<List<Integer>> result = pathSum(node5, 22);

        List<List<Integer>> result2 = pathSum(null, 22);
        int a = 4;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, stack, result);
        return result;
    }

    public static void helper(TreeNode root, int targetSum, Stack<Integer> stack, List<List<Integer>> result){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                stack.push(root.val);
                result.add(new ArrayList<>(stack));
                stack.pop();
                return;
            }
            return;
        }
//        System.out.println(root.val);
        stack.push(root.val);
        helper(root.left, targetSum - root.val, stack, result);
        helper(root.right, targetSum - root.val, stack, result);
        stack.pop();
    }
}
