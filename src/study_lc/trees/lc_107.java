package study_lc.trees;

import study_lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_107 {
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

        List<List<Integer>> result = binaryTreeLevelOrderTraversal(node1);
        int a = 5;
    }

    public static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> nQueue = new LinkedList<>();
        nQueue.add(root);

        while(!nQueue.isEmpty()){
            int the_num_of_node_count = nQueue.size();

            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < the_num_of_node_count; i++){
                TreeNode node = nQueue.remove();

                subList.add(node.val);
                if(node.left != null)
                    nQueue.add(node.left);
                if(node.right != null)
                    nQueue.add(node.right);
            }
            result.add(subList);
        }
        result = reverseResult(result);
        return result;
    }

    public static List<List<Integer>> reverseResult(List<List<Integer>> result){
        int theEnd = result.size() - 1;
        for(int i = 0; i < result.size() / 2; i++){
            int theCurrEnd = theEnd - i;
            List<Integer> temp = result.get(i);
            result.set(i, result.get(theCurrEnd));
            result.set(theCurrEnd, temp);
        }
        return result;
    }
}
