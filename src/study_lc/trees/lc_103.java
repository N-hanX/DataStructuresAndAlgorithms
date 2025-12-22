package study_lc.trees;

import study_lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_103 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        List<List<Integer>> result = binaryTreeZigzagLevel(node1);
        int a = 5;
    }

    public static List<List<Integer>> binaryTreeZigzagLevel(TreeNode root){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean flip = false;
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){

            List<Integer> subList = new ArrayList<>();

            int total_size_of_curr_level = nodeQueue.size();

            for(int i = 0; i < total_size_of_curr_level; i++){
                TreeNode currNode = nodeQueue.remove();
                subList.add(currNode.val);

                if(currNode.left != null){
                    nodeQueue.add(currNode.left);
                }

                if(currNode.right != null){
                    nodeQueue.add(currNode.right);
                }
            }

            if(!flip){

            }else{
                subList = reverseArray(subList);
                // reverse Arraylist sublist
            }
            flip = !flip;
            result.add(subList);
        }
        return result;
    }

    public static List<Integer> reverseArray(List<Integer> arr){
        for(int i = 0; i < arr.size()/2; i++){
            int theEnd = arr.size() - 1;
            int currEnd = theEnd - i;
            int temp = arr.get(i);
            arr.set(i, arr.get(currEnd));
            arr.set(currEnd, temp);
        }
        return arr;
    }
}
