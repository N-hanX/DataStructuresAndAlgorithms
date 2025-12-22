package study_program.lectureNotes.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.right = node5;
        node3.right = node4;

        List<List<Integer>> result = levelOrderBottom(node1);

        int a = 5;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int level_size = queue.size();
            int temp = 0;

            List<Integer> currLevel = new ArrayList<>();

            while(temp < level_size){
                TreeNode node = queue.poll();
                currLevel.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
                temp++;
            }
            result.add(currLevel);
        }

        List<List<Integer>> reverse_result = new ArrayList<>();

        for(int i = result.size() - 1; i >= 0; i--){
            reverse_result.add(result.get(i));
        }

        return reverse_result;
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
