package trees.homework;

import java.util.ArrayList;
import java.util.List;

public class ReverseLevelOrder {

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


        int levelNumber = 0;

        helper(currNode, resultList, levelNumber);

        int a = 5;
    }

    public static void helper(TreeNode currNode, List<List<Integer>> resultList, Integer levelNumber) {
        if (currNode.left_ptr == null && currNode.right_ptr == null) {

            List<Integer> currChildList;
            if(resultList.size() == 0){
                currChildList = new ArrayList<>();;
                resultList.add(currChildList);
            }else{
                currChildList = resultList.get(0);
            }
            currChildList.add(currNode.label);

            return;
        }

        if (currNode.left_ptr != null || currNode.right_ptr != null) {
            // level X

            if (currNode.left_ptr != null) {
                helper(currNode.left_ptr, resultList, levelNumber);
            }
            if (currNode.right_ptr != null) {
                helper(currNode.right_ptr, resultList, levelNumber);
            }
            levelNumber++;

            List<Integer> currChildList;
            if(resultList.size() == levelNumber){
                currChildList = new ArrayList<>();
                resultList.add(currChildList);
            }else{
                currChildList = resultList.get(levelNumber);
            }
            currChildList.add(currNode.label);
        }
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }
}
