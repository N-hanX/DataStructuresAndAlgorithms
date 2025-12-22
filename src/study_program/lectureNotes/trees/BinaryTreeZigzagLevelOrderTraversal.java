package study_program.lectureNotes.trees;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
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

        List<List<Integer>> result = zigzagLevelOrder(node3);

        int a = 5;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int zigzag_switch = 0;

        while(!queue.isEmpty()){
            int level_size = queue.size();
            List<Integer> currLevelNode = new ArrayList<>();
            int temp = 0;

            while(temp < level_size){
                TreeNode node = queue.poll();
                currLevelNode.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
                temp++;
            }
            if(zigzag_switch == 1){
                Collections.reverse(currLevelNode);
                zigzag_switch = 0;
            }else
                zigzag_switch = 1;

            result.add(currLevelNode);
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
