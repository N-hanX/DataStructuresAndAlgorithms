package trees.homework;

import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {
    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList();

    }

    static ArrayList<Integer> preorder(TreeNode root) {
        return null;
    }

    private static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode( int label){
            this.label = label;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }
}
