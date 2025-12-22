package trees.homework;

import java.util.ArrayList;
import java.util.List;

public class printAllPathsThatSum2K {

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

        List<List<Integer>> resultList = new ArrayList();


        int k = 99;
        int currSum = 0;

        List<Integer> curr_List = new ArrayList<>();
        curr_List.add(currNode.label);
        currSum = currSum + currNode.label;

        helper(currNode, resultList, currSum, k, curr_List);


        if(resultList.size() == 0){
            if(curr_List.size() == 1 && curr_List.get(0) == root.label && root.label != k){
                curr_List.set(0,-1);
                resultList.add(curr_List);
            }
        }

        int a = 5;
    }

    public static void helper(TreeNode currNode, List<List<Integer>> resultList, int currSum, int sum, List<Integer> curr_List) {
        if(currNode.left_ptr == null && currNode.right_ptr == null && currSum == sum){
            List<Integer> copyList = new ArrayList<>(curr_List);
            resultList.add(copyList);
            return;
        }
        if (currNode.left_ptr == null && currNode.right_ptr == null) {
            return;
        }

        if (currNode.left_ptr != null || currNode.right_ptr != null) {

            if (currNode.left_ptr != null) {
                curr_List.add(currNode.left_ptr.label);
                currSum = currSum + currNode.left_ptr.label;
                helper(currNode.left_ptr, resultList, currSum, sum, curr_List);
                curr_List.remove(curr_List.size() - 1);
            }
            if (currNode.right_ptr != null) {
                curr_List.add(currNode.right_ptr.label);
                currSum = currSum + currNode.right_ptr.label;
                helper(currNode.right_ptr, resultList, currSum, sum, curr_List);
                curr_List.remove(curr_List.size() - 1);
            }
        }
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }
}
