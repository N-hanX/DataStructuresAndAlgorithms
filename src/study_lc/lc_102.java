package study_lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_102 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        List<List<Integer>> result = getLevelOrderTraversal(t1);
        int a = 5;
    }

    public static List<List<Integer>> getLevelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        TreeNode tempNode; int nodeCount;

        Queue<TreeNode> nodeQ = new LinkedList();
        nodeQ.add(root);

        while( nodeQ.size() > 0 ){
            nodeCount = nodeQ.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < nodeCount; i++){
                tempNode = nodeQ.remove();

                temp.add(tempNode.val);

                if(tempNode.left != null) nodeQ.add(tempNode.left);
                if(tempNode.right != null) nodeQ.add(tempNode.right);
            }
            result.add(temp);
        }
        return result;
    }
}
