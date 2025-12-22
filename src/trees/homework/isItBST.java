package trees.homework;

import java.util.ArrayList;
import java.util.List;

public class isItBST {
    public static void main(String[] args) {


        TreeNode root = new TreeNode();
        root.label = 300;

        TreeNode currentRoot = root;
        currentRoot.left_ptr = new TreeNode();
        currentRoot.left_ptr.label = 200;



        TreeNode currentRightRoot = root;
        currentRightRoot.right_ptr = new TreeNode();
        currentRightRoot.right_ptr.label = 400;


        TreeNode currentLeftLeftNode = currentRoot.left_ptr;
        currentLeftLeftNode.left_ptr = new TreeNode();
        currentLeftLeftNode.left_ptr.label = 100;

        currentLeftLeftNode.right_ptr = new TreeNode();
        currentLeftLeftNode.right_ptr.label = 400;

        if(root == null){
//            return true;
        }

        List<Integer> notBST = new ArrayList<>();
        notBST.add(0);



        TreeNode currNode = root;
        helper(currNode, notBST);

        if(notBST.get(0) == 1){
//            return false;
        }
//        return true;
        int a = 5;
    }


    static void helper(TreeNode currNode, List<Integer> notBST){
        if(currNode.left_ptr == null && currNode.right_ptr == null){
            return;
        }

        if(currNode.left_ptr != null){
            if(currNode.left_ptr.label <= currNode.label){
                helper(currNode.left_ptr, notBST);
            }else{
                notBST.set(0,1);
            }
        }

        if(currNode.right_ptr != null) {
            if (currNode.right_ptr.label >= currNode.label) {
                helper(currNode.right_ptr, notBST);
            } else {
                notBST.set(0, 1);
            }
        }

    }

      public static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
    }
    
    
}

