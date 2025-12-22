package trees.homework;

import java.util.Stack;

public class PostOrderTraversal {
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

        Stack<Integer> stack = new Stack<>();

        while(currNode != null){
            stack.push(currNode.label);
            stack.push(currNode.left_ptr.label);
            stack.push(currNode.right_ptr.label);
        }

    }

    static TreeNode helper(TreeNode currNode){
        if(currNode.left_ptr == null && currNode.right_ptr == null){ //get the left node
            return currNode;
        }

        TreeNode leftNode = null;
        if(currNode.left_ptr != null)
            leftNode = helper(currNode.left_ptr);

        leftNode.left_ptr = currNode.right_ptr;
        leftNode.right_ptr = currNode;

        currNode.left_ptr = null;
        currNode.right_ptr = null;

        return currNode;
    }

    public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }
}
