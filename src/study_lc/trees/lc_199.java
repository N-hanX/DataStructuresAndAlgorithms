package study_lc.trees;

import study_lc.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_199 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;
        t5.right = t6;

        List<Integer> result = binaryTreeRightSideView(t1);
        int a = 5;
    }

    public static List<Integer> binaryTreeRightSideView(TreeNode node){
        // we should keep every nodes in every level
        // first we should get the root
        // then we should get its children
        // then we should get root's children children
        // when we are doing this we need to use queue to process every node respectively
        // and get their children to the end of the queue
        // after process each node of n'th level, we should put them into the n'th list of every list

        Queue<TreeNode> nQueue = new LinkedList<>();
        nQueue.add(node);
        List<Integer> result = new ArrayList<>();

        while(!nQueue.isEmpty()){
            int number_of_nodes_in_nth_level = nQueue.size();
            // we need to do that because children will be added to the end of the queue
            // we need to keep the information of the nth level

            for(int i = 0; i < number_of_nodes_in_nth_level; i++){
                TreeNode theNodeInNLevel = nQueue.remove();

                if(theNodeInNLevel != null) {
                    if(theNodeInNLevel.left != null)
                        nQueue.add(theNodeInNLevel.left);
                    if(theNodeInNLevel.right != null)
                        nQueue.add(theNodeInNLevel.right);

                    if (i == number_of_nodes_in_nth_level - 1) {
                        result.add(theNodeInNLevel.val);
                    }
                }
            }
        }

        return result;
    }
}
