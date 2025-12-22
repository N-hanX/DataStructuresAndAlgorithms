package trees.homework;


import java.util.ArrayList;
import java.util.List;

public class rightSideView {

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

        List<Integer> currList = new ArrayList();
        List<List<Integer>> resultList = new ArrayList();

        currList.add(currNode.label);
        resultList.add(currList);

        int levelNumber = 0;

        helper(currNode, resultList, levelNumber + 1);

        List<Integer> rightSideViewList = new ArrayList<>();

        for(int i = 0; i < resultList.size(); i++){
            List<Integer> currList2 = resultList.get(i);
            rightSideViewList.add(currList2.get( currList2.size() - 1 ));
        }

        int a = 5;
//        return rightSideViewList;

    }

    public static void helper(TreeNode currNode, List<List<Integer>> resultList, int levelNumber) {
        if (currNode.left_ptr == null && currNode.right_ptr == null) {
            return;
        }
        List<Integer> currChildList;

        boolean newList = false;
        if (resultList.size() <= levelNumber) {
            currChildList = new ArrayList();
            newList = true;
        } else {
            currChildList = resultList.get(levelNumber);
        }

        if (currNode.left_ptr != null || currNode.right_ptr != null) {
            // level X

            if (currNode.left_ptr != null) {
                currChildList.add(currNode.left_ptr.label);
            }

            if (currNode.right_ptr != null) {
                currChildList.add(currNode.right_ptr.label);
            }
            if(newList){
                resultList.add(currChildList);
            }


            if (currNode.left_ptr != null) {
                helper(currNode.left_ptr, resultList, levelNumber + 1);
            }
            if (currNode.right_ptr != null) {
                helper(currNode.right_ptr, resultList, levelNumber + 1);
            }
        }
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

}
