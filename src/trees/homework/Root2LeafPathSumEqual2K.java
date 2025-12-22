package trees.homework;

import java.util.ArrayList;
import java.util.List;

public class Root2LeafPathSumEqual2K {
          public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.label = 2;

        TreeNode currentRoot = root;
        currentRoot.left_ptr = new TreeNode();
        currentRoot.left_ptr.label = 5;

        TreeNode currentRightRoot = root;
        currentRightRoot.right_ptr = new TreeNode();
        currentRightRoot.right_ptr.label = 4;

        TreeNode currentLeftLeftNode = currentRoot.left_ptr;
        currentLeftLeftNode.left_ptr = new TreeNode();
        currentLeftLeftNode.left_ptr.label = 0;

        currentLeftLeftNode.right_ptr = new TreeNode();
        currentLeftLeftNode.right_ptr.label = 1;



        TreeNode theRight = currentRightRoot.right_ptr;
        theRight.left_ptr = new TreeNode();
        theRight.left_ptr.label = 3;

        theRight.right_ptr = new TreeNode();
        theRight.right_ptr.label = 6;

        TreeNode currNode = root;

        int k = 7;
        int currSum = 0;

        currSum = currSum + currNode.label;

        List<Integer> list = new ArrayList<>();
        list.add(0);

        helper(currNode, currSum, k, list);
        int a = 5;

        if(list.get(0) == 1){
//        return true;
        }
//        return false;
    }

    public static void helper(TreeNode currNode, int currSum,
                              int sum, List<Integer> list) {
        if(currNode.left_ptr == null && currNode.right_ptr == null && currSum == sum){
            list.set(0,1);
            return;
        }
        if (currNode.left_ptr == null && currNode.right_ptr == null) {
            return;
        }

        if (currNode.left_ptr != null || currNode.right_ptr != null) {

            if (currNode.left_ptr != null) {
                currSum = currSum + currNode.left_ptr.label;
                helper(currNode.left_ptr, currSum, sum, list);
            }
            if (currNode.right_ptr != null) {
                currSum = currSum + currNode.right_ptr.label;
                helper(currNode.right_ptr, currSum, sum, list);
            }
        }
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }
}
