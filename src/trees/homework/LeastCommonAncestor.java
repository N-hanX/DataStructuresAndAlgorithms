package trees.homework;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {
    static boolean foundA;
    static boolean foundB;
    static boolean foundAncestor;

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



        TreeNode nodeA = new TreeNode();
        nodeA.label = 0;

        TreeNode nodeB = new TreeNode();
        nodeB.label = 6;

        Integer ancestor = helper(currNode, nodeA, nodeB);

        int a = 5;
//        return;
    }

    public static Integer helper(TreeNode currNode, TreeNode NodeA, TreeNode NodeB) {
        if(currNode == null){
            return -1;
        }

        if(currNode.label == NodeA.label || currNode.label == NodeB.label ){
            return currNode.label;
        }

        int left = helper(currNode.left_ptr, NodeA, NodeB);
        int right = helper(currNode.right_ptr, NodeA, NodeB);

        if(left != -1 && right != -1){
            return currNode.label;
        }
        if(left!= -1){
            return left;
        }else
            return right;
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }

    public static class NumberObj{
        public Integer ancestor;
    }

}
