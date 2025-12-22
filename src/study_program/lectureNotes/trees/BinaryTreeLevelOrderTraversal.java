package study_program.lectureNotes.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        List<List<Integer>> result = levelOrder(node3);

        int a = 5;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int queue_size = queue.size();
            int temp = 0;

            List<Integer> currLevel = new ArrayList<>();

            while(temp < queue_size){
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if(currNode.left != null)
                    queue.add(currNode.left);

                if(currNode.right != null)
                    queue.add(currNode.right);

                temp++;
            }
            result.add(currLevel);
        }

        return result;
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
