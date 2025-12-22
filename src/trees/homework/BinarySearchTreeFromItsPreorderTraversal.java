package trees.homework;

import java.util.ArrayList;

public class BinarySearchTreeFromItsPreorderTraversal {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(2);

        if(list.isEmpty()){
//            return null;
        }
        TreeNode root = new TreeNode();
        root.label = list.get(0);

        TreeNode currNode = root;
        for(int i = 1; i < list.size(); i++){
//            currNode.
        }
        helper(list);

        int a = 5;
    }

    public static void helper(ArrayList<Integer> preorder) {

    }

    public static class TreeNode {
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(){
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int label){
            this.label = label;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }

}
